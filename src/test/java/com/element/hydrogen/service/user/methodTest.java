package com.element.hydrogen.service.user;

import org.junit.Test;

import java.util.Random;

/**
 * @ClassName methodTest
 * @Description TODO
 * @Author yanyu
 * @Date 2020/9/3 0:12
 * @Version 1.0
 */
public class methodTest {

    int x = 1;
    int y = 3;
    void noReturn(int a,int b){
        a = 0;
        b = 0;
    }
    int Return(int a,int b){
       int c = 0;
       c = a + b;
       return c;
    }
    @Test
    public void methodTest(){
        int a = 1;
        int b = 2;
        noReturn(a, b);
        int c = Return(a,b);
        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
     }


    @Test
    public void RandomTest(){}



}
