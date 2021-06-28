package testingTread;

public class Multithreading_1 {
    public static void main(String[] args) {
        Counter count = new Counter();
        for(int i=0; i<200; i++) {
            CounterThread ct = new CounterThread(count);
            ct.start();
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            System.out.println("bad");
        }
        System.out.println("Counter:" + count.getCounter());
    }
}
