package com.wrh.springboot;

import org.apache.catalina.connector.RequestFacade;

import javax.servlet.Servlet;
import java.util.Hashtable;

public class DemoClass {
    int a = 1;
    final int b = 2;
    static final int e = 3 ;
    String hs = "hello world";
    String hss = new String("hello world");
    String hsss = "hello world";
    String hssss = "hello world world";

    public void print(){
        int c = 4;
        final int d = 5;
        System.out.println(hs==hss);
        System.out.println(hs==hsss);
        System.out.println(hss==hsss);
        System.out.println(hs.toString());
        System.out.println(hss.toString());
    }

    public static void main(String[] args) {
        DemoClass a = new DemoClass();
        a.print();
        System.out.println("11");

    }
}
