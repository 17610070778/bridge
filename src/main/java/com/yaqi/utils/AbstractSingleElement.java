package com.yaqi.utils;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: 王亚奇
 * @Date: 2019-05-08 20:01
 * @Version 1.0
 */
public abstract class AbstractSingleElement<T> extends SingleElement<T> implements Single<T>{

    protected final AbstractSingleElement<T> origin;

    protected AbstractSingleElement(AbstractSingleElement<T> origin) {
        this.origin = origin;
    }

    /**
     * 用于映射元素
     * @param function
     * @param <R>
     * @return
     */
    public <R> SingleElementMap<T, R> map(Function<T, R> function) {
        return new SingleElementMap<>(this, function);
    }

    /**
     * 用于过滤元素
     * @param predicate
     * @return
     */
    public SingleElementFilter<T> filter(Predicate<T> predicate) {
        return new SingleElementFilter<>(this, predicate);
    }

    /**
     * 用于监视元素
     * @param consumer
     * @return
     */
    public SingleElementMonitor<T> monitor(Consumer<T> consumer) {
        return new SingleElementMonitor<>(this, consumer);
    }

    /**
     * 当流中出现错误时，封装结果成T
     * @param predicate
     * @param errMap
     * @return
     */
    public SingleElementErrorMap<T> onErrorMapElement(Predicate<? super Throwable> predicate, Supplier<T> errMap){
        return new SingleElementErrorMap<>(this, predicate, errMap);
    }

}
