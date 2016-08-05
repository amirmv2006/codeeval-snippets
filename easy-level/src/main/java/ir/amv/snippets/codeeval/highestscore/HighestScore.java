package ir.amv.snippets.codeeval.highestscore;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMV on 8/2/2016.
 */
public class HighestScore {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/HighestScore.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split("\\|");
            List<Integer> max = new ArrayList<Integer>();
            for (String scores : split) {
                String[] split1 = scores.trim().split(" ");
                for (int i = 0; i < split1.length; i++) {
                    Integer score = Integer.valueOf(split1[i]);
                    if (i < max.size()) {
                        if (score > max.get(i)) {
                            max.set(i, score);
                        }
                    } else {
                        max.add(score);
                    }
                }
            }
            System.out.println(max.toString().replace("[", "").replace("]", "").replace(",", ""));
        }
    }
}
