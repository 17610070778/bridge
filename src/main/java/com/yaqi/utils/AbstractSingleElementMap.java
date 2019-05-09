package com.yaqi.utils;


/**
 *  用于扩展Map的抽象类
 * @Author: 王亚奇
 * @Date: 2019-05-09 14:36
 * @Version 1.0
 */
public abstract class AbstractSingleElementMap<T, R> extends AbstractSingleElement<T> {
    protected AbstractSingleElement<R> origin ;
    protected AbstractSingleElementMap(AbstractSingleElement<R> origin) {
        super(null);
        this.origin = origin;
    }

}
