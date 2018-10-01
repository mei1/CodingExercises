package org.qimei.exercises;

import java.util.*;

public class MinMaxSum {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
    	Arrays.sort(arr);
    	long minValue = 0;
    	long maxValue = 0;
    	for (int i = 0; i < 4; i++){
    		minValue = minValue + arr[i];
    	}
    	for (int i = 4; i > 0; i--){
    		maxValue = maxValue + arr[i];
    	}
    	System.out.println("minValue:"+minValue+",maxValue:"+maxValue);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};

//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < 5; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;

        miniMaxSum(arr);

        scanner.close();
    }
}
