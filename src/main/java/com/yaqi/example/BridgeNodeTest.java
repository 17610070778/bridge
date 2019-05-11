package com.yaqi.example;

import com.yaqi.utils.BridgeBuild;

/**
 * 测试
 * @author 王亚奇
 * @date 2019/5/9 20:57
 */
public class BridgeNodeTest {
    public static void main(String[] args) {
        System.out.println("***************************************华丽分割线*********************************");
        // ***********************使用工具前**********************
        String a = "aaaa";
        String ab = a + "bbbb";
        // 日志记录
        System.out.println(ab);
        // 数据转换，将字符串映射为数字
        int c = 1234;
        // 过滤数据
        if (c > 2000){
            c = 1234;
        }else {
            c = 0;
        }
        // 如果c为0转换为1000
        if (c == 0){
            c = 1000;
        }
        // 处理异常
        try {
            // 制造异常
            int number = 1/0;
        }catch (RuntimeException e){
            // 将数据变为10
            c = 10;
        }
        System.out.println(c);
        System.out.println("***************************************华丽分割线*********************************");
        // *******************************使用工具后*************************
        Integer integer = BridgeBuild.from("aaaa")
                .map(s -> s + "bbbbb")
                // 日志记录
                .monitor(System.out::println)
                .map(s -> 1234)
                // 过滤数据，将大于2000的数据放行，否则放行null
                .filter(i -> i > 2000)
                // 如果数据为null，转换为1000
                .ifEmptySwitch(() -> 1000)
                .map(i -> {
                    // 人为制造异常
                    if(true){
                        throw new RuntimeException("人为制造异常");
                    }
                    return i;
                })
                // 如果发生除零异常，将桥梁中的数据转换为10
                .onErrorMapElement(ex -> ex instanceof RuntimeException, () -> 10)
                // 触发桥梁内的数据走动
                .trigger()
                // 获取桥梁中的数据
                .get();
        // 打印结果为10
        System.out.println(integer);
        System.out.println("***************************************华丽分割线*********************************");
    }
}
