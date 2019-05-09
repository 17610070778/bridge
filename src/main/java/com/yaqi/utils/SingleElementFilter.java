package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:15
 * @Version 1.0
 */
public class SingleElementFilter<T> extends AbstractSingleElement<T> {
    private Predicate<T> predicate;

    /**
     * 通过构造方法来创建对象
     * @param origin
     * @param predicate
     */
    public SingleElementFilter(AbstractSingleElement<T> origin, Predicate<T> predicate) {
        super(origin);
        this.predicate = Objects.requireNonNull(predicate);
    }

    /**
     * 按照传入的规则来过滤元素
     * @return
     */
    @Override
    public Supplier<T> touch() {
        T t = origin.touch().get();
        return () -> predicate.test(t) ? t : null;
    }

}
