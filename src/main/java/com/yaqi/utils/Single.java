package com.yaqi.utils;

import java.util.function.Supplier;

/**
 * 用于定义每一个SingleElement对象所触发的方法
 *
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:01
 * @Version 1.0
 */
public interface Single<T> {
    /**
     * 此方法将会被链式触发
     * @return
     */
    Supplier<T> touch();
}
