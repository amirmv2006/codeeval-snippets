package ir.amv.snippets.codeeval.sumofdigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class SumOfDigits {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/SumOfDigits.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            Integer number = Integer.parseInt(line);
            Integer result = 0;
            while (number != 0) {
                result += number % 10;
                number /= 10;
            }
            System.out.println(result);
        }
    }
}
