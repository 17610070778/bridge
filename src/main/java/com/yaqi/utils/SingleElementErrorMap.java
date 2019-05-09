package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 当发生错误的时候转换数据
 * @Author: 王亚奇
 * @Date: 2019-05-09 17:40
 * @Version 1.0
 */
public class SingleElementErrorMap<T> extends AbstractSingleElement<T>{
    private final Supplier<T> errMap;
    private final Predicate<? super Throwable> predicate;
    /**
     * 通过错误来构造错误处理对象
     * @param origin
     */
    protected SingleElementErrorMap(AbstractSingleElement<T> origin, Predicate<? super Throwable> predicate, Supplier<T> errMap) {
        super(origin);
        this.errMap = Objects.requireNonNull(errMap);
        this.predicate = predicate;
    }

    @Override
    public Supplier<T> touch() {
        T t;
        try {
            t = origin.touch().get();
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
