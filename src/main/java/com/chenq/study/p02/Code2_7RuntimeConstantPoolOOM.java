package com.chenq.study.p02;

/**
 * String.intern()返回引用的测试
 * Created by chen on 2019/2/21.
 */
public class Code2_7RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("中国").append("钓鱼岛").toString();
        System.out.println(str1.intern() == str1);
        // java这个字符在system类中initializeSystemClass方法中执行的sun.misc.Version.init();
        // Version中有个静态常量java
        // 加载过了，坑啊，作者都不说清楚点
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

}
