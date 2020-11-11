package com.example.demo.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * Cglib proxy demo.
 * Main implementation steps:
 * 1. Implement the net.sf.cglib.proxy.MethodInterceptor interface
 * 2. Create Enhancer object(which is used to create proxy object), set target class and callback object.
 * 3. Create proxy object by invoke enhancer.create()
 * 4. Call method on proxy object
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        //Generate proxy class under given path
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "out");

        //2. Create Enhancer object, which is used to create proxy object.
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class); //Set target class
        enhancer.setCallback(new MyMethodInterceptor()); //Set callback object

        //3. Create proxy by invoke enhancer.create().
        Hello helloProxy = (Hello) enhancer.create();

        //4. Call method on proxy object.
        helloProxy.sayHello("Doris");
    }
}
