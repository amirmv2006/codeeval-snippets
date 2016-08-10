package ir.amv.snippets.codeeval.longestcommonsubsequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/9/2016.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) throws IOException {
        File file = new File("hard-level/LongestCommonSubsequence.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) {
                System.out.println();
                continue;
            }
            StringTokenizer mainTokenizer = new StringTokenizer(line, ";");
            if (mainTokenizer.countTokens() < 2) {
                System.out.println();
                continue;
            }
            StringBuffer first = new StringBuffer(mainTokenizer.nextToken());
            StringBuffer second = new StringBuffer(mainTokenizer.nextToken());
            StringBuffer common = findCommonString(
                    first.length() > second.length() ? second : first,
                    first.length() > second.length() ? first  : second);
            System.out.println(common);
        }
    }

    private static StringBuffer findCommonString(StringBuffer shorter, StringBuffer longer) {
        StringBuffer result = new StringBuffer("");
        int[][] foundInices = new int[shorter.length()][longer.length()];
        for (int i = 0; i < shorter.length(); i++) {
            char charAt = shorter.charAt(i);
            String substring = shorter.substring(0, i);
            int lastChar = substring.lastIndexOf(charAt);
            String str = String.valueOf(charAt);
            int from = 0;
            if (lastChar != -1) {
                int k = 0;
                from = foundInices[lastChar][k] + 1;
                if (from == 0) { // not found previously
                    from = longer.length() - 1;
                    foundInices[i][0] = -1;
                }
            }
            if (from < longer.length() - 1) {
                int k = 0;
                foundInices[i][0] = longer.indexOf(str, from);
                int nextIndex;
                while (foundInices[i][k] < longer.length() - 1 && (nextIndex = longer.indexOf(str, foundInices[i][k] + 1)) != -1) {
                    k++;
                    foundInices[i][k] = nextIndex;
                }
                foundInices[i][k + 1] = -1;
            }
        }
        int[] longestSubArray = new int[0];
        for (int i = 0; i < foundInices.length; i++) {
            int[] counter = new int[foundInices.length];
            int counterNextIndex = 0;
            for (int j = i; j < foundInices.length; j++) {
                for (int k = 0; k < foundInices.length; k++) {
                    int foundInice = foundInices[j][k];
                    if (foundInice == -1) {
                        break;
                    }
                    if (counterNextIndex == 0 || foundInice > counter[counterNextIndex - 1]) {
                        counter[counterNextIndex] = foundInice;
                        counterNextIndex++;
                        break;
                    }
                }
            }
            if (counterNextIndex > longestSubArray.length) {
                longestSubArray = Arrays.copyOf(counter, counterNextIndex);
            }
        }
        for (Integer integer : longestSubArray) {
            result.append(longer.charAt(integer));
        }
        return result;
    }

}
