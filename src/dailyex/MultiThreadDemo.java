package dailyex;

/**
 * @author Major Tom
 * @date 2020/8/18 18:27
 * @description 多线程Demo
 */
public class MultiThreadDemo {
    public static void main(String[] args) {
       /* //实例化三个对象
        Mythread mythread1=new Mythread("mythread1");
        Mythread mythread2=new Mythread("mythread2");
        Mythread mythread3=new Mythread("mythread3");
        //创建线程
        Thread th1=new Thread(mythread1);
        Thread th2=new Thread(mythread2);
        Thread th3=new Thread(mythread3);
        //开启线程
        th1.start();
        th2.start();
        th3.start();*/
        //PS:不可以直接使用mythread1.run()来开启线程必须得创建线程，通过start()方法开启一个线程
        /**
         * 输出：线程mythread3打印了.....664984
         *      线程mythread3打印了.....664985
         *      线程mythread3打印了.....664986
         *      线程mythread3打印了.....664987
         *      线程mythread3打印了.....664988
         *      线程mythread1打印了.....585490
         *      可以看到线程的切换
         */
        //由于继承了Thread类，此时可以直接创建线程
        MyThread2 th1=new MyThread2("thread1");
        MyThread2 th2=new MyThread2("thread2");
        //开启线程
        th1.start();
        th2.start();
        /**
         * 输出：线程thread1打印了.....344025
         *      线程thread1打印了.....344026
         *      线程thread2打印了.....310678
         *      线程thread2打印了.....310679
         *      线程thread2打印了.....310680
         */
    }
}
//1.实现Runnable接口，覆盖run方法
class Mythread implements Runnable{
    //表示线程名称
    private String name;

    public Mythread(String name) {
        this.name = name;
    }
    //重点，覆盖run方法
    @Override
    public void run() {
        for (long i = 0; i < 100000000000000L; i++) {
            System.out.println("线程"+name+"打印了"+"....."+i);
        }
    }
}

//2.继承Thread类，重写run方法
class MyThread2 extends Thread{
    //表示线程的名称
    private String name;
    public MyThread2(String name) {
        this.name = name;
    }
    public void run(){
        for (long i = 0; i < 100000000000000L; i++) {
            System.out.println("线程"+name+"打印了"+"....."+i);
        }
    }
}
