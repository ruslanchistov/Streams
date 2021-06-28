package testingTread;

public class Printer {
    private static int number = 0;
    static synchronized void print(){
        number += 1;
        System.out.println("Thread "+number);
    }
}
