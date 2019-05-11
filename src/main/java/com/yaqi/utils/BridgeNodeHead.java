package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 使用对象，或者生成器来构建桥梁头部
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:07
 * @Version 1.0
 */
public class BridgeNodeHead<T> extends Bridge<T> {
    private final Supplier<T> supplier;

    /**
     * 使用生成器，来创建数据源
     * @param supplier
     */
    public BridgeNodeHead(Supplier<T> supplier){
        super(null);
        this.supplier = Objects.requireNonNull(supplier, "supplier 不能为空");
    }

    @Override
    public Supplier trigger() {
        return () -> Objects.requireNonNull(supplier.get(), "桥梁头节点的值不能为空");
    }


}
