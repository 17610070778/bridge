package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 如果桥梁入口端参数为null，则将响应的预处理对象返回到出参
 * @author 王亚奇
 * @date 2019/5/10 13:56
 */
public class BridgeNodeIfEmptySwitch<T> extends Bridge<T> {
    private final Supplier<T> switchSupplier;
    protected BridgeNodeIfEmptySwitch(Bridge<T> origin, Supplier<T> switchSupplier) {
        super(origin);
        this.switchSupplier = Objects.requireNonNull(switchSupplier);
    }

    @Override
    public Supplier<T> trigger() {
        T t = origin.trigger().get();
        if (t == null){
            T t1 = switchSupplier.get();
            return () -> t1;
        }
        return () -> t;
    }
}
