package ir.amv.snippets.codeeval.lowercase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class Lowercase {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/Lowercase.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            System.out.println(line.toLowerCase());
        }
    }
}
