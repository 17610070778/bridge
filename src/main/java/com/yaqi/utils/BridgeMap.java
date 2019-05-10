package com.yaqi.utils;


/**
 *  用于扩展桥梁节点,当桥梁的入参，和桥梁的返回值泛型不一致时；
 * @Author: 王亚奇
 * @Date: 2019-05-09 14:36
 * @Version 1.0
 */
public abstract class BridgeMap<T, R> extends Bridge<T> {
    protected Bridge<R> origin ;
    protected BridgeMap(Bridge<R> origin) {
        super(null);
        this.origin = origin;
    }

}
