package com.yaqi.example;

import com.yaqi.utils.SingleElement;

/**
 * @author 王亚奇
 * @date 2019/5/9 20:57
 */
public class SingleElementTest {
    public static void main(String[] args) {
        // ***************************************华丽分割线*********************************
        // 使用工具前
        String a = "aaaa";
        String ab = a + "bbbb";
        System.out.println(ab);
        int c = 1234;
        if (c > 1000){
            c = 1000;
        }
        System.out.println(c);
        // ***************************************华丽分割线*********************************
        // 使用工具后
        Integer integer = SingleElement.from("aaaa")
                .map(s -> s + "bbbbb")
                // 日志记录
                .monitor(System.out::println)
                .map(s -> 1234)
                // 过滤数据
                .filter(i -> i > 1000)
                .touch()
                .get();
        // 打印结果为1234
        System.out.println(integer);
        // ***************************************华丽分割线*********************************
    }
}
