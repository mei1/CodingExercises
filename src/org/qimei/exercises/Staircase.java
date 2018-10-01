package org.qimei.exercises;

import java.util.*;

public class Staircase {

    // Complete the staircase function below.
    static void staircase(int n) {
    	String result = "";
    	String str = "#";
    	for (int i = 1; i <= n; i++) {
    		result = new String(new char[i]).replace("\0", str);
    		System.out.println(result.format("%1$"+n+ "s", result));
    	}

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(6);

//        scanner.close();
    }
}
