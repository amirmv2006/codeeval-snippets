package ir.amv.snippets.codeeval.multiplicationtables;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by AMV on 8/2/2016.
 */
public class MultiplicationTables {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.printf("% 4d",(i + 1) * (j + 1));
            }
            System.out.println();
        }
    }
}
