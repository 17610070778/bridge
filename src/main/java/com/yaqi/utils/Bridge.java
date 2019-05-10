package com.yaqi.utils;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 所有继承此抽象类的类都可以链式调用来构建数据传动的桥梁
 * @Author: 王亚奇
 * @Date: 2019-05-08 20:01
 * @Version 1.0
 */
public abstract class Bridge<T> extends BridgeBuild<T> implements BridgeNodeTrigger<T> {

    protected final Bridge<T> origin;

    protected Bridge(Bridge<T> origin) {
        this.origin = origin;
    }

    /**
     * 用于将桥梁节点这头的元素映射为另头的元素
     * @param function
     * @param <R>
     * @return
     */
    public <R> BridgeNodeMap<T, R> map(Function<T, R> function) {
        return new BridgeNodeMap<>(this, function);
    }

    /**
     * 用于过滤桥梁节点一头的元素是否符合要求，符合则通过，不符合则不通过
     * @param predicate
     * @return
     */
    public BridgeNodeFilter<T> filter(Predicate<T> predicate) {
        return new BridgeNodeFilter<>(this, predicate);
    }

    /**
     * 用于监视从桥梁节点中通过的元素
     * @param consumer
     * @return
     */
    public BridgeNodeMonitor<T> monitor(Consumer<T> consumer) {
        return new BridgeNodeMonitor<>(this, consumer);
    }

    /**
     * 用于监视当前桥梁节点之前的桥梁节点出否出现过错误，出错则做出相应的errMap动作
     * @param predicate
     * @param errMap
     * @return
     */
    public BridgeNodeErrorMap<T> onErrorMapElement(Predicate<? super Throwable> predicate, Supplier<T> errMap){
        return new BridgeNodeErrorMap<>(this, predicate, errMap);
    }

    /**
     * 重载以上方法
     * @param predicate
     * @param t
     * @return
     */
    public BridgeNodeErrorMap<T> onErrorMapElement(Predicate<? super Throwable> predicate, T t){
        return new BridgeNodeErrorMap<>(this, predicate, () -> t);
    }

    /**
     * 如果通过当前桥梁节点入口的元素为null，则桥梁节点出口的元素就是生成器生成的元素
     * @param switchSupplier
     * @return
     */
    public BridgeNodeIfEmptySwitch<T> ifEmptySwitch(Supplier<T> switchSupplier){
        return new BridgeNodeIfEmptySwitch<>(this, switchSupplier);
    }

    /**
     * 重载以上方法
     * @param t
     * @return
     */
    public BridgeNodeIfEmptySwitch<T> ifEmptySwitch(T t){
        return new BridgeNodeIfEmptySwitch<>(this, () -> t);
    }
}
