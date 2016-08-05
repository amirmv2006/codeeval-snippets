package ir.amv.snippets.codeeval.mthtolastelement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/5/2016.
 */
public class MthToLastElement {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/MthToLastElement.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer mainTokenizer = new StringTokenizer(line, " ");
            int arrayLength = mainTokenizer.countTokens() - 1;
            char[] data = new char[arrayLength];
            for (int i = 0; i < data.length; i++) {
                data[i] = mainTokenizer.nextToken().charAt(0);
            }
            int index = Integer.parseInt(mainTokenizer.nextToken());
            if (index <= arrayLength) {
                System.out.println(data[arrayLength - index]);
            } else {
                System.out.println();
            }
        }
    }
}
