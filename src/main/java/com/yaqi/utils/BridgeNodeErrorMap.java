package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 如果桥梁中的数据发生了错误
 * @Author: 王亚奇
 * @Date: 2019-05-09 17:40
 * @Version 1.0
 */
public class BridgeNodeErrorMap<T> extends Bridge<T> {
    private final Supplier<T> errMap;
    private final Predicate<? super Throwable> predicate;
    /**
     * 通过错误预处理以及错误后要返回的值，来构造桥梁节点对象
     * @param origin
     */
    protected BridgeNodeErrorMap(Bridge<T> origin, Predicate<? super Throwable> predicate, Supplier<T> errMap) {
        super(origin);
        this.errMap = Objects.requireNonNull(errMap);
        this.predicate = Objects.requireNonNull(predicate, "predicate 不能为空");
    }

    @Override
    public Supplier<T> trigger() {
        T t;
        try {
            t = origin.trigger().get();
        }catch (Exception e){
            T t1 = errMap.get();
            boolean test = predicate.test(e);
            if (test){
                return () -> t1;
            }
            throw e;
        }
        return () -> t;
    }
}
