package com.service.gateway.api;

import com.google.common.collect.Lists;
import com.service.gateway.config.DynamicRouteService;
import com.service.gateway.config.GatewayFilterDefinition;
import com.service.gateway.config.GatewayPredicateDefinition;
import com.service.gateway.config.GatewayRouteDefinition;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : pc
 * @date : 2020/5/6
 */
@RestController
@RequestMapping("/route")
@Api(tags = "10000-路由管理")
public class DynamicRouteController {
    @Autowired
    private DynamicRouteService dynamicRouteService;

    @PostMapping
    public String add(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
        RouteDefinition definition = assembleRouteDefinition(gatewayRouteDefinition);
        return dynamicRouteService.add(definition);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return dynamicRouteService.delete(id);
    }

    @PutMapping
    public String update(@RequestBody GatewayRouteDefinition gatewayRouteDefinition){
        RouteDefinition definition = assembleRouteDefinition(gatewayRouteDefinition);
        return dynamicRouteService.update(definition);
    }


    private RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gatewayRouteDefinition) {

        RouteDefinition definition = new RouteDefinition();

        // ID
        definition.setId(gatewayRouteDefinition.getId());

        // Predicates
        List<PredicateDefinition> predicateDefinitions = Lists.newArrayList();
        for (GatewayPredicateDefinition gatewayPredicateDefinition : gatewayRouteDefinition.getPredicates()) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gatewayPredicateDefinition.getArgs());
            predicate.setName(gatewayPredicateDefinition.getName());
            predicateDefinitions.add(predicate);
        }
        definition.setPredicates(predicateDefinitions);

        // Filters
        List<FilterDefinition> filterDefinitions = new ArrayList<>();
        for (GatewayFilterDefinition gatewayFilterDefinition : gatewayRouteDefinition.getFilters()) {
            FilterDefinition filter = new FilterDefinition();
            filter.setArgs(gatewayFilterDefinition.getArgs());
            filter.setName(gatewayFilterDefinition.getName());
            filterDefinitions.add(filter);
        }
        definition.setFilters(filterDefinitions);

        // URI
        URI uri = UriComponentsBuilder.fromUriString(gatewayRouteDefinition.getUri()).build().toUri();
        definition.setUri(uri);

        return definition;
    }
}
