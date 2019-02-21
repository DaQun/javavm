package com.chenq.study.p02;

/**
 * 创建线程导致内存溢出异常
 * VM Args：-Xss2M （这时候不妨设大些）
 * Created by chen on 2019/2/21.
 *
 */
public class Code2_5JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        Code2_5JavaVMStackOOM oom = new Code2_5JavaVMStackOOM();
        /**危险代码！！！，不要轻易执行，windows下容易导致电脑假死*/
//        oom.stackLeakByThread();
    }
}
