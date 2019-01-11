//package com.dnp.service.zuul.filter;
//
//import com.dnp.service.zuul.feign.PttFeignService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * 身份验证服务器，权限验证一起
// * @author 华仔
// * @date 2018/10/18 10:27
// */
//@Component
//public class AuthFilter implements GlobalFilter {
//
//    Logger LOG = LoggerFactory.getLogger(AuthFilter.class);
//
//    @Autowired
//    private PttFeignService pttFeignService;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
//        //String pttAuth = pttFeignService.hello("xiaoming");
//        //LOG.info("pttAuto = {}", pttAuth);
//        return gatewayFilterChain.filter(serverWebExchange);
//    }
//
//}
