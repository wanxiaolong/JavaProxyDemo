package com.example.demo.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * JDK dynamic proxy demo.
 * Main implementation steps:
 * 1. Implement the java.lang.reflect.InvocationHandler interface
 * 2. Create customized InvocationHandler to receive method calls from interface
 * 3. Create proxy object by Proxy.newProxyInstance()
 * 4. Call method on proxy object
 */
public class JdkProxyDemo {
    public static void main(String[] args) throws Exception {
        // Save the generated files during executing this program
        // (class com.misc.ProxyGenerator has logic to use 'saveGeneratedFiles' attribute,
        // open ProxyGenerator class for detail)
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        //2. Create customized InvocationHandler to receive method calls from interface
        MyInvocationHandler handler = new MyInvocationHandler(new HelloImpl());

        //3. Create proxy object by Proxy.newProxyInstance()
        IHello hello = (IHello)Proxy.newProxyInstance(IHello.class.getClassLoader(), new Class[]{IHello.class}, handler);

        //4. Call method on proxy object
        hello.sayHello("Doris");

        System.out.println();
    }
}
