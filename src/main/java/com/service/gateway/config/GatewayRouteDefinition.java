package com.service.gateway.config;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * @author : pc
 * @date : 2020/5/6
 */
@Data
public class GatewayRouteDefinition {
    /**
     * 路由配置
     */
    private String id;
    /**
     * 路由断言集合配置
     */
    private List<GatewayPredicateDefinition> predicates = Lists.newArrayList();
    /**
     * 路由过滤器集合配置
     */
    private List<GatewayFilterDefinition> filters = Lists.newArrayList();
    /**
     * 路由规则转发的url
     */
    private String uri;
    /**
     * 路由的执行顺序
     */
    private int order = 0;
}
