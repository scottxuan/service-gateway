package com.service.gateway.config;

import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * @author : pc
 * @date : 2020/5/6
 */
public interface DynamicRouteService {
    /**
     * 路由信息添加
     *
     * @param routeDefinition
     * @return
     */
    String add(RouteDefinition routeDefinition);

    /**
     * 路由信息更新
     *
     * @param routeDefinition
     * @return
     */
    String update(RouteDefinition routeDefinition);

    /**
     * 路由信息删除
     *
     * @param id
     * @return
     */
    String delete(String id);
}
