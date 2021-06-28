package testingTread;

public class Multithreading_2 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            Thread stream = new Thread(Printer :: print);
            stream.start();
        }
    }
}
