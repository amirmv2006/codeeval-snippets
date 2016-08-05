package ir.amv.snippets.codeeval.cleanupthewords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class CleanUpTheWords {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/CleanUpTheWords.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String processedLine = "";
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (Character.toUpperCase(c) != c) {
                    processedLine += c;
                } else {
                    if (!processedLine.equals("") && processedLine.charAt(processedLine.length() - 1) != ' ') {
                        processedLine += ' ';
                    }
                }
            }
            System.out.println(processedLine);
        }
    }
}
