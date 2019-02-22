package com.chenq.study.p02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * Created by chen on 2019/2/22.
 */
public class Code2_9DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;
    // Unsafe类只有引导类积极在其才会返回实例
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
