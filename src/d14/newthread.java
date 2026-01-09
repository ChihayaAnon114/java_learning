package d14;

public class newthread extends Thread{
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
        newthread testThread = new newthread();
//（4）调用start方法开启线程
        testThread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}
