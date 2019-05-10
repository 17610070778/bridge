package com.yaqi.utils;

import java.util.function.Supplier;

/**
 * 用于定义桥梁中每一个桥梁结点对象所默认触发的方法
 * @Author: 王亚奇
 * @Date: 2019-05-08 19:01
 * @Version 1.0
 */
public interface BridgeNodeTrigger<T> {
    /**
     * 此方法将会触发桥梁元素走动,使每个桥梁节点对元素做出相应的处理
     * 如果上一个桥梁节点返回值为null，那么当前的函数式接口将不执行，也返回null;
     * @return
     */
    Supplier<T> trigger();
}
