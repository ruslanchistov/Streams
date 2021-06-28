package testingTread;

public class CounterThread extends Thread{
    final Counter count;

    public CounterThread(Counter count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            count.increaseCounter();
        }
    }
}
