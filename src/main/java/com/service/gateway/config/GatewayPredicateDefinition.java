package com.service.gateway.config;

import lombok.Data;

import java.util.Map;

/**
 * @author : pc
 * @date : 2020/5/6
 */
@Data
public class GatewayPredicateDefinition {
    /**
     * 断言对应的name
     */
    private String name;
    /**
     * 配置的断言规则
     */
    private Map<String, String> args;
}
