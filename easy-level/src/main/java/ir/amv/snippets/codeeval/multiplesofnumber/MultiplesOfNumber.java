package ir.amv.snippets.codeeval.multiplesofnumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class MultiplesOfNumber {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/MultiplesOfNumber.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");
            int x = Integer.valueOf(split[0]);
            int n = Integer.valueOf(split[1]);
            int nMult = n;
            while (nMult < x) {
                nMult += n;
            }
            System.out.println(nMult);
        }
    }
}
