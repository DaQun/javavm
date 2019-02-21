package com.chenq.study.p02;

import java.util.ArrayList;

/**
 * java堆内存溢出异常测试
 * Created by chen on 2019/2/21.
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 虚拟机参数：最小堆内存20m 最大堆内存20m 虚拟机在出现异常时Dump出当前的内存堆转储快照
 */
public class Code2_3HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<OOMObject>();
        try{
            while (true) {
                list.add(new OOMObject());
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(list.size());
        }


    }


}
