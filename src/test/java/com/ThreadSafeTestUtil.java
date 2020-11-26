package com;

import java.util.ArrayList;

/**
 * @ClassName ThreadSafeTestUtil
 * @Description TODO
 * @Author yanyu
 * @Date 2020/11/25 23:03
 * @Version 1.0
 */
public class ThreadSafeTestUtil extends  Thread implements Runnable {

    private static ThreadSafeTestUtil concurrentProblem = new ThreadSafeTestUtil();
    private static int count=0;
    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            new ThreadSafeTestUtil().start();
        }

    }



    public  void run() {
         synchronized (this){
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("线程名:"+Thread.currentThread().getName() + ":" + (count++));
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

/*    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);   // 9997  i=10000
        System.out.println(list.size()); // 918  i=1000
    }*/
}
