//package com.service.gateway.bean;
//
//import com.google.common.collect.Lists;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
///**
// * @author : scottxuan
// */
//@Component
//public class FilterChain implements Ordered {
//
//    public static final String ANON = "anon";
//
//    @Bean("apiFilter")
//    public List<String> filterChain(){
//        List<String> filterChain = Lists.newArrayList();
//        filterChain.add("/api/v1/login");
//        return filterChain;
//    }
//
//    @Override
//    public int getOrder() {
//        return -1;
//    }
//}
