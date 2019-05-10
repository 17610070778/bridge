package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 用于过滤从当前桥梁节点中通过的元素是否符合要求
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:15
 * @Version 1.0
 */
public class BridgeNodeFilter<T> extends Bridge<T> {
    private Predicate<T> predicate;

    /**
     * 使用断言来判断桥梁中通过的元素
     * @param origin
     * @param predicate
     */
    public BridgeNodeFilter(Bridge<T> origin, Predicate<T> predicate) {
        super(origin);
        this.predicate = Objects.requireNonNull(predicate);
    }


    @Override
    public Supplier<T> trigger() {
        T t = origin.trigger().get();
        return () -> predicate.test(t) ? t : null;
    }

}
