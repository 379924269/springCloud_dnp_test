# oauth2学习

## 重点看看WebSecurityConfigurerAdapter与ResourceServerConfigurerAdapter区别和用法
web的优先级比resource的优先级低   web@order(100) 而resource @order(3) 
- [参考地址*](https://www.jianshu.com/p/fe1194ca8ecd)

- [oauth2四种授权模式认证流程参考](https://blog.csdn.net/lixiang987654321/article/details/83381494)
- [springbootsecurity拦截器图片](doc/springbootsecurityFilter.png)

##FQA
### 我在oauth2学习中遇到的问题
#### 1、我忘了在client中配置密码模式：
- 我要用密码模式，但是客户端没有配置。所以要用什么模式就需要给客户端配置什么模式。

#### 2、AuthenticationManager没配置好
````
- 1、在WebSecurityConfig中定义一个
@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}

- 2、在OAuth2ServerConfig映入AuthenticationManager
@Autowired
@Qualifier("authenticationManagerBean")
private AuthenticationManager authenticationManager;
````

#### 3、访问oauth/token 包401：authentication is required
就是要在OAuth2ServerConfig类中添加下面配置配置：
````
@Override
public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
            .tokenKeyAccess("permitAll()")
            .checkTokenAccess("permitAll()")
            .allowFormAuthenticationForClients();
}
````
[具体错误处理参考地址](https://blog.csdn.net/u012040869/article/details/80140515?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase)

#### 4、访问oauth/token 报：Bad Client Credentials
oauth2数据库存的密码（用加密算法加密了的）和传上来的密码（原始密码）

#### 5、ResourceServerConfigurerAdapter优先级比WebSecurityConfigurerAdapter更高
[参考地址](https://www.jianshu.com/p/fe1194ca8ecd)