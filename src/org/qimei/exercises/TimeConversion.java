package org.qimei.exercises;

import java.io.*;
import java.text.*;
import java.util.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) throws ParseException {
    	SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
    	Date date = parseFormat.parse(s);
        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
        
        return displayFormat.format(date);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "07:05:45PM";

        String result = timeConversion(s);
        System.out.println("result:"+result);

//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}
