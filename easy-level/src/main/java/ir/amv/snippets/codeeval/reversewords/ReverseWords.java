package ir.amv.snippets.codeeval.reversewords;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by AMV on 8/2/2016.
 */
public class ReverseWords {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/ReverseWords.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            StringTokenizer tokenizer = new StringTokenizer(line, " ");
            Stack<String> wordsStack = new Stack<String>();
            while (tokenizer.hasMoreTokens()) {
                wordsStack.push(tokenizer.nextToken());
            }
            while (!wordsStack.isEmpty()) {
                System.out.print(wordsStack.pop());
                if (!wordsStack.isEmpty()) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
