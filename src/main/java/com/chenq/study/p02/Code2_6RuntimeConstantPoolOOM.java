package com.chenq.study.p02;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * <p>本机是1.8的，会一直运行。1.6下会抛异常,因为1.6以前的版本是讲常量池放在永久代中的，后面的版本开始逐渐‘去永久代’</p>
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by chen on 2019/2/21.
 */
public class Code2_6RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        // 10MB的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
