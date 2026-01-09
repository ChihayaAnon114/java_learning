package d14;

public class NewRunable implements Runnable{
    //（2）重写run()方法,run方法中为线程体
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
    /*
    多线程实现方式二：Runnable接口
    （1）创建线程类声明实现Runnable接口
    （2）重写run()方法
    （3）创建Runnable接口实现类对象
    （4）new一个Thread类对象，并将线程的实例化对象作为参数传递
    （5）调用start方法开启线程
     */
    //main为主线程
    public static void main(String[] args) {
    //（3）执行线程需要丢入Runnable接口实现类，调用start()方法
        new Thread(new NewRunable()).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}