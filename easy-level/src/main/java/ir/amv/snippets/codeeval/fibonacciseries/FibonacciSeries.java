package ir.amv.snippets.codeeval.fibonacciseries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class FibonacciSeries {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/FibonacciSeries.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            Integer n = Integer.parseInt(line);
            if (n == 0) {
                System.out.println(0);
            } else {
                int[] lastTwoFn = new int[2];
                lastTwoFn[0] = 0;
                lastTwoFn[1] = 1;
                int counter = 2;
                while (counter <= n) {
                    lastTwoFn[1] = lastTwoFn[0] + lastTwoFn[1];
                    lastTwoFn[0] = lastTwoFn[1] - lastTwoFn[0];
                    counter++;
                }
                System.out.println(lastTwoFn[1]);
            }
        }
    }
}
