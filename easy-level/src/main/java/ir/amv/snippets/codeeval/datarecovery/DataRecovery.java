package ir.amv.snippets.codeeval.datarecovery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMV on 8/2/2016.
 */
public class DataRecovery {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/DataRecovery.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(";");
            String[] words = split[0].split(" ");
            String[] indices = split[1].split(" ");
            List<String> ordered = new ArrayList<String>(words.length + 1);
            for (int i = 0; i < words.length; i++) {
                ordered.add(null);
            }
            for (int i = 0; i < words.length - 1; i++) {
                ordered.set(Integer.parseInt(indices[i]) - 1, words[i]);
            }
            for (int i = 0; i < ordered.size(); i++) {
                String word = ordered.get(i);
                System.out.print(word == null ? words[words.length - 1] : word);
                if (i < ordered.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
