package d14;

public class Newthread extends Thread{
            /*
        多线程实现方式一：继承Thread类
        （1）自定义线程类，继承Thread类
        （2）重写run()方法，编写线程执行体
        （3）创建一个线程对象
        （4）调用start方法开启线程
        注意：线程开启不一定立即执行，由CPU安排调度
         */


    //一个进程
    //基于runnable实现的
    //（2）重写run()方法,run方法中为线程体
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);

        }
    }
    //main为主线程
    public static void main(String[] args) {
    //（3）创建一个线程对象
        Newthread testThread = new Newthread();
    //（4）调用start方法开启线程
        testThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程--" + i);
        }

    }
}
