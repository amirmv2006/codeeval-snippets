package ir.amv.snippets.codeeval.trickortreat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/2/2016.
 */
public class TrickOrTreat {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/TrickOrTreat.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(",");
            Integer v = 0;
            Integer z = 0;
            Integer w = 0;
            Integer h = 0;
            for (String data : split) {
                String[] split1 = data.trim().split("\\:");
                if (split1[0].startsWith("V")) {
                    v = Integer.parseInt(split1[1].trim());
                } else if (split1[0].startsWith("Z")) {
                    z = Integer.parseInt(split1[1].trim());
                } else if (split1[0].startsWith("W")) {
                    w = Integer.parseInt(split1[1].trim());
                } else if (split1[0].startsWith("H")) {
                    h = Integer.parseInt(split1[1].trim());
                }
            }
            System.out.println(
                    (5 * w + 4 * z + 3 * v) * h /
                            (w + z + v)

            );
        }
    }
}
