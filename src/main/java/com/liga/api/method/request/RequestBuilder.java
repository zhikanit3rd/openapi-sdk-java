package com.liga.api.method.request;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
@FunctionalInterface
public interface RequestBuilder<Builder>{

    /**
     * 给builder设值
     * @param builder
     * @return
     */
    Builder configure(Builder builder);
}
