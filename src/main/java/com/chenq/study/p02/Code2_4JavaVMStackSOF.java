package com.chenq.study.p02;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * VM Args：-Xss128k
 * Created by chen on 2019/2/21.
 */
public class Code2_4JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        Code2_4JavaVMStackSOF oom = new Code2_4JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
