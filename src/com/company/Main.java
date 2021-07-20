package com.company;

import com.company.interfaces.ClickAction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        /**    System.out.println("~~~~~~~");
         // write your code here
         //            Class<?> clazz = Class.forName("com.company.Action");
         Action clazz = new Action();
         //            Class<?> interfaces = Class.forName("com.company.interfaces.ClickAction");
         ClickAction interfaceClick = new ClickAction() {
        @Override public void onClickAction() {
        System.out.println("moni------");
        }
        };
         //MyInvocationHandler(clazz) 使用多态接收实现接口的类
         ClickAction clickAction = (ClickAction) Proxy.newProxyInstance(clazz.getClass().getClassLoader(), clazz.getClass().getInterfaces(), new MyInvocationHandler(clazz));
         clickAction.onClickAction();
         **/

        try {
            Class<?> clazz = Class.forName("com.company.Action");
            Action action = (Action) clazz.getDeclaredConstructor().newInstance();
            Class<?> interfaces[] = clazz.getInterfaces();
            //执行接口方式一
            ClickAction clickAction = (ClickAction) Proxy.newProxyInstance(action.getClass().getClassLoader(), interfaces, new MyInvocationHandler(action));
            clickAction.onClickAction();
            //执行接口方式二
            Method method = action.getClass().getDeclaredMethod("mainMethod", ClickAction.class);
            method.invoke(action, clickAction);

            //也可以对接口进行绑定eg  btn.setOnclick(clickAction);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
