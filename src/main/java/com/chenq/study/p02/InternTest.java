package com.chenq.study.p02;

import static com.chenq.study.p02.InternTest.test1;

/**
 * Created by chen on 2019/2/21.
 */
public class InternTest {
    public static void main(String[] args) {
//        test1();
        System.out.println("a" == "a");
    }

    static void test1() {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1.intern() == s2);
    }
    static void test2() {
        // 第一次，创建了两个对象，一个是堆中的string对象，一个是常量池中的"abc"
        String a = new String("abc");
        // 第二次，创建一个对象，堆中的另外一个string对象
        String b = new String("abc");
        System.out.println(a.intern() == b.intern());// true
        System.out.println(a.intern() == b);// false
        System.out.println(a.intern() == a);// false
        /*
         * 会在常量池中存一个指向堆中的那个对象的引用。
         * 不存在往往是String s3 = new String("1") + new String("1");
         * 这种形式，会在堆中有一个s3指向的11的对象和常量池中的1对象
         * 在这里就是体现的堆中的内存地址不一样，但对应的同一个常量池中的string 第一个比较时常量池中的该对象和自身比较
         * 下面两个比较则是常量池中的对象和堆中的两个对象进行比较
         */
        String poolstr = "abc";
        // 直接从字符串常量池中获取
        System.out.println(a.intern() == poolstr);// true
        System.out.println(b.intern() == poolstr);// true
        /*
         * 这里新声明并赋值了一个poolstr，值为常量池中的字符串"abc",将它和a.intern()和b.inten()比较就是和自身比较
         */

        String str = new String("a") + new String("b");
        System.out.println(str.intern() == str);// true
        /*
         * str创建了3个对象，在堆中有一个"ab"，在常量池中有一个"a"和"b" 比较str.intern()和str会得到true
         * 在jdk1.7之后，会在常量池中存一个指向堆中的那个对象的引用。
         * 调用str.intern()会在常量池中存储一个指向堆中"ab"的引用，也就是说它和堆中的对象实际是等价的，因此==时返回true
         */

        String strtwo = "ab";
        System.out.println(strtwo == str);// true
        /*
         * 常量池中已存在ab，所以会直接将strtwo指向常量池中的"ab",即堆中str对象的引用，因此相等
         */

    }
}