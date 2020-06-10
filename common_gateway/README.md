## springcloud zuul学习
学习一下springcloud Gateway，Spring Cloud Gateway旨在提供一种简单而有效的方法来路由到API，并为它们提供跨领域的关注，例如：安全性，监视/指标和弹性。

### 参考文档
我简单的看了一下，连个文档内容应该是差不多的。 我还是选择看中文文档，如果你要用具体的那个版本请看英文好点
- [Spring Cloud Gateway 2.1.0 中文官网文档](https://cloud.tencent.com/developer/article/1403887)
- [Spring Cloud Gateway官网](https://spring.io/projects/spring-cloud-gateway#learn)


### 路由注解 具体参考参考文档
````
 routes:
        - id: device
          uri: lb://device   //跳转服务
          predicates:
          - Path=/device/**   //匹配的路径
          filters:
          - StripPrefix=1   //指请求带了一个前缀的，跳到服务的时候会去掉device
````