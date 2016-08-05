package ir.amv.snippets.codeeval.bitpositions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class BitPositions {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/BitPositions.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");
            Integer number = Integer.parseInt(split[0]);
            Integer p1 = Integer.parseInt(split[1]) - 1;
            p1 = 1 << p1;
            Integer p2 = Integer.parseInt(split[2]) - 1;
            p2 = 1 << p2;
            System.out.println(((number & p1) / p1) == ((number & p2) / p2));
        }
    }
}
