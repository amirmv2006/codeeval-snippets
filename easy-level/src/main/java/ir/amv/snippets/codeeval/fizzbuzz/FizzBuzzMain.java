package ir.amv.snippets.codeeval.fizzbuzz;

import java.io.*;

/**
 * Created by AMV on 8/1/2016.
 */
public class FizzBuzzMain {

    public static void main(String[] args) throws IOException {
        assert args != null;
        assert args.length > 0;
        String filePath = args[0];
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            String fizzDividerStr = split[0];
            String buzzDividerStr = split[1];
            String countStr = split[2];
            Integer fizz = Integer.valueOf(fizzDividerStr);
            Integer buzz = Integer.valueOf(buzzDividerStr);
            Integer count = Integer.valueOf(countStr);
            for (Integer i = 1; i <= count; i++) {
                if (((i % fizz) == 0) && ((i % buzz) == 0)) {
                    System.out.print("FB");
                } else if (((i % fizz) == 0)) {
                    System.out.print("F");
                } else if (((i % buzz) == 0)) {
                    System.out.print("B");
                } else {
                    System.out.print(i);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
