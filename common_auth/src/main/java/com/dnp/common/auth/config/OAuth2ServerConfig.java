package com.dnp.common.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * description: 配置资源服务和授权服务
 *
 * @author: 华仔
 * @date: 2020/5/9
 */
@Configuration
public class OAuth2ServerConfig {

    private static final String QQ_RESOURCE_ID = "qq";

    @Configuration
    @EnableResourceServer()
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(QQ_RESOURCE_ID).stateless(true);
            // 如果关闭 stateless，则 accessToken 使用时的 session id 会被记录，后续请求不携带 accessToken 也可以正常响应
            // resources.resourceId(QQ_RESOURCE_ID).stateless(false);
        }

        /* 配置参考地址：1、https://www.jianshu.com/p/fe1194ca8ecd */
        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/resource").authorizeRequests().anyRequest().authenticated();

            http.csrf().disable();
        }

    }

    //    参考地址：https://www.cnblogs.com/xingxueliao/p/5911292.html
    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        /*客户端信息管理， 可以放到数据库中， 可以放到内存中。 为了简单  我们放到内存中
        ClientDetailsServiceConfigurer：用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
        AuthorizationServerSecurityConfigurer：用来配置令牌端点(Token Endpoint)的安全约束.
        AuthorizationServerEndpointsConfigurer：用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。*/
        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory().withClient("client")
                    .resourceIds(QQ_RESOURCE_ID)
                    .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password")
                    .authorities("ROLE_CLIENT")
                    .scopes("get_user_info", "get_fanslist")
                    .secret("$2a$10$JF/a1NXNIHa8nxJR/pKbE.OJ7Sqpskojmj5xHXyIRjXVb2iim/Vj6")
                    .redirectUris("http://localhost:8081/aiqiyi/qq/redirect")
                    .autoApprove(true)
                    .autoApprove("get_user_info")
                    .and()
                    .withClient("youku")
                    .resourceIds(QQ_RESOURCE_ID)
                    .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password")
                    .authorities("ROLE_CLIENT")
                    .scopes("get_user_info", "get_fanslist")
                    .secret("secret")
                    .redirectUris("http://localhost:8082/youku/qq/redirect");

        }

        //        配置授权端点的URL（Endpoint URLs）：
        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints.tokenStore(new InMemoryTokenStore());
            endpoints.authenticationManager(authenticationManager);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
            security
                    .tokenKeyAccess("permitAll()")
                    .checkTokenAccess("permitAll()")
                    .allowFormAuthenticationForClients();
        }
    }
}
