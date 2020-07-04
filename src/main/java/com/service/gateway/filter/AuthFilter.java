//package com.service.gateway.filter;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
///**
// * @author : scottxuan
// */
//@Component
//public class AuthFilter implements GlobalFilter, Ordered {
//
//    /**
//     * 所有请求必须携带/api/v1
//     */
//    private static final String API_V1 = "/api";
//    /**
//     * 请求头token名称
//     */
//    private static final String AUTHORIZE_TOKEN = "Authorization";
//
//    @Autowired
//    @Qualifier("apiFilter")
//    private List<String> filterChain;
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //获取Request、Response对象
//        ServerHttpRequest request = exchange.getRequest();
//        ServerHttpResponse response = exchange.getResponse();
//        //获取请求的URI
//        String path = request.getURI().getPath();
//        if (!path.contains(API_V1)) {
//            return chain.filter(exchange);
//        }
//        if (filterChain.contains(path)) {
//            return chain.filter(exchange);
//        }
//        return null;
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
