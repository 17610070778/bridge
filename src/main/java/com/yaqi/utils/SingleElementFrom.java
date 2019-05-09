package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:07
 * @Version 1.0
 */
public class SingleElementFrom<T> extends AbstractSingleElement<T> {
    private Supplier<T> supplier;

    /**
     * 使用生成器，来创建数据源
     * @param supplier
     */
    public SingleElementFrom(Supplier<T> supplier){
        super(null);
        this.supplier = Objects.requireNonNull(supplier);
    }

    @Override
    public Supplier touch() {
        return () -> Objects.requireNonNull(supplier.get());
    }


}
