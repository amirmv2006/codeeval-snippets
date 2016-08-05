package ir.amv.snippets.codeeval.timetoeat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by AMV on 8/2/2016.
 */
public class TimeToEat {

    public static void main(String[] args) throws IOException {
        File file = new File("easy-level/TimeToEat.data");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] split = line.split(" ");
            List<Date> dates = new ArrayList<Date>();
            for (String s : split) {
                try {
                    Date d = dateFormat.parse(s);
                    dates.add(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            Collections.sort(dates, new Comparator<Date>() {
                public int compare(Date o1, Date o2) {
                    return -1 * o1.compareTo(o2);
                }
            });
            for (int i = 0; i < dates.size(); i++) {
                Date date = dates.get(i);
                System.out.print(dateFormat.format(date));
                if (i < dates.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
