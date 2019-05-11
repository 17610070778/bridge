package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 用于创建桥梁源头
 * @Author: 王亚奇bridgeNode
 * @Date: 2019-05-08 19:02
 * @Version 1.0
 */

public abstract class BridgeBuild<T> {

    /**
     * 桥梁源头数据来源于对象
     * @param t
     * @param <T>
     * @return
     */
    public static <T> BridgeNodeHead<T> from(T t) {
        return from(() -> Objects.requireNonNull(t, "t 不能为空"));
    }

    /**
     * 桥梁源头数据来源于生成器
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> BridgeNodeHead<T> from(Supplier<T> supplier) {
        return new BridgeNodeHead<>(supplier);
    }

}
