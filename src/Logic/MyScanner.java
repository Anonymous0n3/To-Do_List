package Logic;

import java.util.Scanner;

public class MyScanner {
    private static Scanner scanner = null;

    private MyScanner() {
        scanner = new Scanner(System.in);
    }

    public static Scanner getInstance() {
        if (scanner == null) {
            new MyScanner();
        }
        return scanner;
    }


}
