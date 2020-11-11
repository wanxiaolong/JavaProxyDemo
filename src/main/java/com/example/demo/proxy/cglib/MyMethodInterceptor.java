package com.example.demo.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println(">>>> Before method invocation");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println(">>>> after method invocation");
        return object;
    }
}
