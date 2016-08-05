package ir.amv.snippets.codeeval.gameoflife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by AMV on 8/5/2016.
 */
public class GameOfLife {

    public static void main(String[] args) throws IOException {
        File file = new File("moderate-level/GameOfLife.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        int row = 0;
        boolean[][] alive = null;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if (alive == null) {
                alive = new boolean[line.length()][line.length()];
            }
            for (int col = 0; col < alive.length; col++) {
                alive[row][col] = (line.charAt(col) == '*');
            }
            row++;
        }
        for (int i = 0; i < 10; i++) {
            boolean[][] newGen = new boolean[alive.length][alive.length];
            for (int nRow = 0; nRow < newGen.length; nRow++) {
                for (int nCol = 0; nCol < newGen.length; nCol++) {
                    newGen[nRow][nCol] = getNewStatus(alive, nRow, nCol);
                }
            }
            alive = newGen;
        }
        for (int i = 0; i < alive.length; i++) {
            for (int j = 0; j < alive[i].length; j++) {
                System.out.print(alive[i][j] ? '*':'.');
            }
            System.out.println();
        }
    }

    private static boolean getNewStatus(boolean[][] alive, int nRow, int nCol) {
        int numberOfLiveNeighbours = getNumberOfLiveNeighbours(alive, nRow, nCol);
        if (alive[nRow][nCol]) {
            return numberOfLiveNeighbours == 2 || numberOfLiveNeighbours == 3;
        } else {
            return numberOfLiveNeighbours == 3;
        }
    }

    private static int getNumberOfLiveNeighbours(boolean[][] alive, int nRow, int nCol) {
        int result = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (!(i == 0 && j == 0) && alive[i + nRow][j + nCol]) {
                        result++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
        }
        return result;
    }
}
