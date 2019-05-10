package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 用于监视当前桥梁节点中走过的元素
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:16
 * @Version 1.0
 */
public class BridgeNodeMonitor<T> extends Bridge<T> {
    private Consumer<T> consumer;

    /**
     * 通过预消费者来创建桥梁节点
     * @param origin
     * @param consumer
     */
    public BridgeNodeMonitor(Bridge<T> origin, Consumer<T> consumer) {
        super(origin);
        this.consumer = Objects.requireNonNull(consumer);
    }

    /**
     * 触发Consume，来监视元素
     * @return
     */
    @Override
    public Supplier<T> trigger() {
        T t = origin.trigger().get();
        if (t != null){
            consumer.accept(t);
        }
        return () -> t;
    }

}
