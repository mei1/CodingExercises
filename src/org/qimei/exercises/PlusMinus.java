package org.qimei.exercises;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
    	List<Integer> positive = new ArrayList<Integer>();
    	List<Integer> negative = new ArrayList<Integer>();
    	List<Integer> zero = new ArrayList<Integer>();
    	
    	for (int i = 0; i < arr.length; i++){
    		int currNum = arr[i];
    		if (currNum>0){
    			positive.add(currNum);
    		} else if (currNum<0){
    			negative.add(currNum);
    		} else if (currNum==0){
    			zero.add(currNum);
    		}
    	}
    	System.out.println("positives:"+positive.size());
    	System.out.println("negative:"+negative.size());
    	System.out.println("zero:"+zero.size());

    	BigDecimal positiveBD = new BigDecimal(positive.size());
        BigDecimal negativeBD = new BigDecimal(negative.size());
        BigDecimal zeroBD = new BigDecimal(zero.size());
        BigDecimal total = new BigDecimal(arr.length);
        
        BigDecimal positiveRatio = positiveBD.divide(total,6, BigDecimal.ROUND_HALF_UP);
        BigDecimal negativeRatio = negativeBD.divide(total,6, BigDecimal.ROUND_HALF_UP);
        BigDecimal zeroRatio = zeroBD.divide(total,6, BigDecimal.ROUND_HALF_UP);
        
        System.out.println(positiveRatio);
        System.out.println(negativeRatio);
        System.out.println(zeroRatio);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = {-4, 3, -9, 0, 4, 1};

//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }

        plusMinus(arr);

//        scanner.close();
    }
}
