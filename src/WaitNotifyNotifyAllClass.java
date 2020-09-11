
//Задача 1

public class WaitNotifyNotifyAllClass {
    private final Object monitor = new Object();
    private volatile char letter='A';

    public static void main(String[] args) {
        WaitNotifyNotifyAllClass wnna =new WaitNotifyNotifyAllClass();
        Thread t1 = new Thread(()->{
            wnna.printA();
        });t1.start();
        Thread t2 = new Thread(()->{
            wnna.printB();
        });t2.start();
Thread t3 =new Thread(()->{
   wnna.printC();
});t3.start();
    }
public void printA(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letter!='A'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println('A');
                letter='B';
                monitor.notify();
            }
        }

}
public void printB(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letter!='B') {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println('B');
                letter='C';
                monitor.notifyAll();
            }

        }
}
public void printC(){
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                while (letter!='C'){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println('C');
                letter='A';
                monitor.notifyAll();
            }

        }
}
}
