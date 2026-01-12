package d14;

public class test {
    public static void main(String[] args) {
        Thread t=new Newthread();
        t.start();//开始进程
        t.stop();
    }
}
