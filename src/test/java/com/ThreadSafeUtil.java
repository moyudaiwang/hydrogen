package com;

import lombok.SneakyThrows;

import java.util.ArrayList;

/**
 * @ClassName ThreadSafeUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/25 22:42
 * @Version 1.0
 */
public class ThreadSafeUtil extends  Thread{

        public  static StringBuffer xc =new StringBuffer("0");
        public  static StringBuffer sid =new StringBuffer("0");
        public  static String xcString ="";
        public  static String sidString ="";
        public  static String[] lbsName ={"sh","bj","gz","nj","cd","cs","qd","sy"};
        public  static int xci =0;
        @SneakyThrows
        public  void  run (){

            synchronized (this) {
                sidString =String.valueOf(xci++);
                for (String a : lbsName) {
                    xc = new StringBuffer(a + "***********" + sidString);
                    //  xc.append(a+"***"+sid);
                   // System.out.println(xc.toString());


                    System.out.println("线程名:"+a + ":" + (xci++));
                    Thread.sleep(10);
                }

            }
        }

    public static void main(String[] args) {
        ThreadSafeUtil threadSafeUtil =new ThreadSafeUtil();

        for (int i = 0; i < 4; i++) {
            new ThreadSafeUtil().start();
        }
    }




}
