package com.company;

import com.company.interfaces.ClickAction;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private ClickAction clickAction;

    public MyInvocationHandler(ClickAction listener) {
        this.clickAction = listener;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(clickAction, args);//拦截对象
        System.out.println("invoke=====");
        return invoke;
    }
}
