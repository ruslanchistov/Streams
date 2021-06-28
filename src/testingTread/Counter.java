package testingTread;

public class Counter {
    private long count = 0;

    public synchronized void increaseCounter() {
        count++;
    }

    public long getCounter() {
        return count;
    }
}
