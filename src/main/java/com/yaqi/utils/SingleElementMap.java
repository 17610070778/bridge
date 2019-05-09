package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 用于映射对象中的数据
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:13
 * @Version 1.0
 */
public class SingleElementMap<R, T> extends AbstractSingleElementMap<T, R>{

    private Function<R, T> mapper;


    /**
     * 构造方法创造数据源
     * @param origin
     * @param mapper
     */
    public SingleElementMap(AbstractSingleElement<R> origin, Function<R, T> mapper) {
        super(origin);
        this.mapper = Objects.requireNonNull(mapper);
    }


    /**
     * 用于映射元素
     * @return
     */
    @Override
    public Supplier<T> touch() {
        return () -> mapper.apply(Objects.requireNonNull(origin.touch().get()));
    }

}
