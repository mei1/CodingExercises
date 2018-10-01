package org.qimei.exercises;

import java.io.*;
import java.util.*;

public class SimpleArraySum {

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
    	int sum = 0;
        for (int i = 0; i < ar.length; i++) {
        	sum = sum + ar[i];
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[]{1, 2, 3, 4, 10, 11};

//        String[] arItems = scanner.nextLine().split(" ");
//
//        for (int arItr = 0; arItr < arCount; arItr++) {
//            int arItem = Integer.parseInt(arItems[arItr].trim());
//            ar[arItr] = arItem;
//        }

        int result = simpleArraySum(ar);
        System.out.println("result:"+result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
    }
}
