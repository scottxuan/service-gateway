package com.service.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author : pc
 * @date : 2020/5/6
 */
@Service
public class DynamicRouteServiceImpl implements DynamicRouteService, ApplicationEventPublisherAware {
    @Autowired
    private RouteDefinitionWriter writer;

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    @Override
    public String add(RouteDefinition definition) {
        try {
            writer.save(Mono.just(definition)).subscribe();
            this.publisher.publishEvent(new RefreshRoutesEvent(this));
        } catch (Exception e) {
            return "add fail, routeId: " + definition.getId();
        }
        return "SUCCESS";
    }

    @Override
    public String update(RouteDefinition definition) {
        String id = definition.getId();
        try {
            writer.delete(Mono.just(id));
        } catch (Exception e) {
            return "update fail, not find routeId: " + id;
        }
        try {
            writer.save(Mono.just(definition)).subscribe();
            this.publisher.publishEvent(new RefreshRoutesEvent(this));
        } catch (Exception e) {
            return "update route fail, routeId: " + id;
        }
        return "SUCCESS";
    }

    @Override
    public String delete(String id) {
        try {
            writer.delete(Mono.just(id))
                    .then(Mono.defer(()-> Mono.just(ResponseEntity.ok().build())))
                    .onErrorResume(t-> t instanceof NotFoundException, t-> Mono.just(ResponseEntity.notFound().build()));
        } catch (Exception e) {
            return "delete fail, routeId: " + id;
        }
        return "SUCCESS";
    }
}
