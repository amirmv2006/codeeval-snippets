package ir.amv.snippets.codeeval.lightsout;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/8/2016.
 */
public class LightsOut {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/LightsOut.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer mainTokenizer = new StringTokenizer(line, " ");
            int rowCount = Integer.valueOf(mainTokenizer.nextToken());
            int colCount = Integer.valueOf(mainTokenizer.nextToken());
//            boolean[][] lampIsOn = new boolean[rowCount][colCount];
            String dataStr = mainTokenizer.nextToken();
            StringTokenizer rowTokenizer = new StringTokenizer(dataStr, "|");
            BigInteger data = new BigInteger("0");
            for (int row = 0; row < rowCount; row++) {
                String rowData = rowTokenizer.nextToken();
                for (int col = 0; col < colCount; col++) {
//                    lampIsOn[row][col] = rowData.charAt(col) == 'O';
                    if (rowData.charAt(col) == 'O') {
                        data = data.setBit(row * colCount + col);
                    }
                }
            }
//            System.out.println(data);
//            for (int i = 0; i < rowCount; i++) {
//                for (int j = 0; j < colCount; j++) {
//                    System.out.print(data.testBit(i * colCount + j) ? 'O' : 'o');
//                }
//                System.out.println();
//            }
            List<BigInteger> history = new ArrayList<BigInteger>();
            int pathLength = getShortestPath(data, rowCount, colCount, history, new ArrayList<Point>());
            System.out.println("pathLength = " + pathLength);
            return;
        }
    }

    private static int getShortestPath(BigInteger data, int rowCount, int colCount, List<BigInteger> history, List<Point> moves) {
        if (data.equals(new BigInteger("0"))) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Point move = new Point(i, j);
                if (!moves.contains(move)) {
                    moves.add(move);
                    BigInteger moved = move(data, rowCount, colCount, i, j);
                    if (moved != null && !history.contains(moved)) {
                        history.add(moved);
                        int neighborPath = getShortestPath(moved, rowCount, colCount, history, moves);
                        if (neighborPath < min) {
                            min = neighborPath;
                        }
                    }
                }
            }
        }
        return min + 1;
    }

    private static BigInteger move(BigInteger data, int rowCount, int colCount, int i, int j) {
        if (i > 0) {
            int index = (i - 1) * colCount + j;
            data = data.flipBit(index);
        }
        if (j > 0) {
            int index = (i) * colCount + (j - 1);
            data = data.flipBit(index);
        }
        if (i < rowCount - 1) {
            int index = (i + 1) * colCount + j;
            data = data.flipBit(index);
        }
        if (j < colCount - 1) {
            int index = i * colCount + (j + 1);
            data = data.flipBit(index);
        }
        int index = i * colCount + j;
        return data.flipBit(index);
    }
}
