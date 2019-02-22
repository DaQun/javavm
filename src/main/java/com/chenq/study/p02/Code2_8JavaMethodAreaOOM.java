package com.chenq.study.p02;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLIB使方法区出现内存溢出异常
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by chen on 2019/2/22.
 */
public class Code2_8JavaMethodAreaOOM {
    // 本机不管怎么运行都不会抛异常
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
