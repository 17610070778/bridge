package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**可用于监视从中流过的元素
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:16
 * @Version 1.0
 */
public class SingleElementMonitor<T> extends AbstractSingleElement<T> {
    private Consumer<T> consumer;

    /**
     * 通过构造方法来创建数据源
     * @param origin
     * @param consumer
     */
    public SingleElementMonitor(AbstractSingleElement<T> origin, Consumer<T> consumer) {
        super(origin);
        this.consumer = Objects.requireNonNull(consumer);
    }

    /**
     * 触发Consume，来监视元素
     * @return
     */
    @Override
    public Supplier<T> touch() {
        T t = origin.touch().get();
        Objects.requireNonNull(t);
        consumer.accept(t);
        return () -> t;
    }

}
