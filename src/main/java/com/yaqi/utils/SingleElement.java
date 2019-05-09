package com.yaqi.utils;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * 用于创建数据源
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:02
 * @Version 1.0
 */

public abstract class SingleElement<T> {

    /**
     * 数据来源自对象
     * @param t
     * @param <T>
     * @return
     */
    public static <T> SingleElementFrom<T> from(T t) {
        return from(() -> Objects.requireNonNull(t));
    }

    /**
     * 数据来源自生成器
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> SingleElementFrom<T> from(Supplier<T> supplier) {
        return new SingleElementFrom<>(supplier);
    }

}
