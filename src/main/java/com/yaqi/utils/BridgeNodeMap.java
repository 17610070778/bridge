package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 用于将桥梁一端的数据，映射为另一端的数据
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:13
 * @Version 1.0
 */
public class BridgeNodeMap<R, T> extends BridgeMap<T, R> {

    private Function<R, T> mapper;


    /**
     * 通过预映射器，来映射桥梁节点中的元素
     * @param origin
     * @param mapper
     */
    public BridgeNodeMap(Bridge<R> origin, Function<R, T> mapper) {
        super(origin);
        this.mapper = Objects.requireNonNull(mapper);
    }


    @Override
    public Supplier<T> trigger() {
        R r = origin.trigger().get();
        return r == null ? () -> null : () -> mapper.apply(r);
    }

}
