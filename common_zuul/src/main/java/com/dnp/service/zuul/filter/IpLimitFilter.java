package com.dnp.service.zuul.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * 如果是内部服务器则直接通过，springcloud内部服务器的相互调用
 *
 * @author 华仔
 * @date 2018/10/18 10:07
 */
@Component
public class IpLimitFilter extends AbstractGatewayFilterFactory<Object> {
    Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public GatewayFilter apply(Object o) {
        return (exchange, chain) -> {
            LOG.info("=====ipFilter=====");
            String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            LOG.info("===ip=== {}", ip);
            return chain.filter(exchange);
        };
    }
}
