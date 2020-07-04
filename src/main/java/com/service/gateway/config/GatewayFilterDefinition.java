package com.service.gateway.config;

import lombok.Data;

import java.util.Map;

/**
 * @author : pc
 * @date : 2020/5/6
 */
@Data
public class GatewayFilterDefinition {
    /**
     * 过滤器对应的名称
     */
    private String name;
    /**
     * 配置的过滤器规则
     */
    private Map<String,String> args;
}
