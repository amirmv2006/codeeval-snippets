package ir.amv.snippets.codeeval.sortmatrixcolumns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/4/2016.
 */
public class SortMatrixColumns {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/SortMatrixColumns.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer mainTokenizer = new StringTokenizer(line, "|");
            int rowNo = mainTokenizer.countTokens();
            int[][] data = new int[rowNo][rowNo];
            for (int i = 0; i < rowNo; i++) {
                StringTokenizer numbersTokenizer = new StringTokenizer(mainTokenizer.nextToken(), " ");
                for (int j = 0; j < rowNo; j++) {
                    data[j][i] = Integer.parseInt(numbersTokenizer.nextToken());
                }
            }
            Arrays.sort(data, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    for (int i = 0; i < o1.length - 1; i++) {
                        int result = o1[i] - o2[i];
                        if (result != 0) {
                            return result;
                        }
                    }
                    return o1[o1.length - 1] - o2[o2.length - 1];
                }
            });
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.print(data[j][i]);
                    if (j != data[i].length - 1) {
                        System.out.print(" ");
                    }
                }
                if (i != data.length - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
    }
}
