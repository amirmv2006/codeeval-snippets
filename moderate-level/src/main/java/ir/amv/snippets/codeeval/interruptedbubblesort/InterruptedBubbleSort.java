package ir.amv.snippets.codeeval.interruptedbubblesort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/3/2016.
 */
public class InterruptedBubbleSort {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/InterruptedBubbleSort.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer mainTokenizer = new StringTokenizer(line, "|");
            StringTokenizer numbersTokenizer = new StringTokenizer(mainTokenizer.nextToken(), " ");
            int[] data = new int[numbersTokenizer.countTokens()];
            for (int i = 0; i < data.length; i++) {
                data[i] = Integer.parseInt(numbersTokenizer.nextToken());
            }
            long loopCount = Long.parseLong(mainTokenizer.nextToken().trim());
            for (long i = 0; i < loopCount; i++) {
                int tmp = -1;
                boolean sorted = true;
                for (int j = 0; j < data.length - 1; j++) {
                    if (tmp == -1) {
                        if (data[j] > data[j+1]) {
                            sorted = false;
                            tmp = data[j];
                            data[j] = data[j+1];
                        }
                    } else {
                        if (data[j + 1] < tmp) {
                            data[j] = data[j + 1];
                        } else {
                            data[j] = tmp;
                            tmp = -1;
                        }
                    }
                }
                if (tmp != -1) {
                    data[data.length - 1] = tmp;
                }
                if (sorted) {
                    break;
                }
            }
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
    }
}
