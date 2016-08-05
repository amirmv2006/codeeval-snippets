package ir.amv.snippets.codeeval.passtriangle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/3/2016.
 */
public class PassTriangle {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/PassTriangle.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        int countLines = 0;
        while (buffer.readLine() != null) {
            countLines++;
        }
        buffer.close();
        buffer = new BufferedReader(new FileReader(file));
        int[] data = new int[(countLines * (countLines + 1)) / 2];
        int index = 0;
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer mainTokenizer = new StringTokenizer(line, " ");
            int countTokens = mainTokenizer.countTokens();
            for (int i = 0; i < countTokens; i++) {
                data[index++] = Integer.parseInt(mainTokenizer.nextToken());
            }
        }
        for (int rowNo = 2; rowNo <= countLines; rowNo++) {
            for (int colNo = 0; colNo < rowNo; colNo++) {
                calcMaxSum(data, rowNo, colNo);
            }
        }
        int max = 0;
        for (int col = 0; col < countLines; col++) {
            int val = data[getIndexForLine(countLines, col)];
            if (val > max) {
                max = val;
            }
        }
        System.out.println(max);
    }

    private static void calcMaxSum(int[] data, int row, int col) {
        int index = getIndexForLine(row, col);
        int thisCellData = data[index];
        if (col == 0) {
            data[index] = thisCellData + data[getIndexForLine(row - 1, col)];
        } else if (col == (row - 1)) {
            data[index] = thisCellData + data[getIndexForLine(row - 1, col - 1)];
        } else {
            data[index] =thisCellData + Math.max(
                    data[getIndexForLine(row - 1, col - 1)],
                    data[getIndexForLine(row - 1, col)]);
        }
    }

    public static int getIndexForLine(int row, int column) {
        return ((row * (row - 1)) / 2) + column;
    }
}
