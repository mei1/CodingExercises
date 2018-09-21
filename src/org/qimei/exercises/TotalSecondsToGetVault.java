package org.qimei.codingGames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TotalSecondsToGetVault {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String[] vowels = {"A", "E", "I", "O", "U"};
        Integer[] digits = {0,1,2,3,4,5,6,7,8,9};
        List<Integer> list1 = new ArrayList<>();
        int totalSecs = 1;
        int numberV = 0;
        int vowelsV = 0;
        // System.err.println("vowels:"+vowels[0]);
        int R = in.nextInt();
        int V = in.nextInt();
        System.err.println("robber:"+R);
        System.err.println("vaults:"+V);
        System.err.println("V/R:"+V/R);
        int chunkSize = V/R;
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> chunkList = new ArrayList<>(list1.size() / chunkSize);
        
        int counter = 0;
        for (int i = 0; i < V; i++) {
            counter++;
            System.err.println("counter:"+counter);
            int C = in.nextInt();
            int N = in.nextInt();
            System.err.println("characters of vault:"+C);
            System.err.println("first x char:"+N);
            numberV = N;
            vowelsV = C-N;
            int tempTotalSecs = 1;
            if (0!=vowelsV){
                for (int v = vowelsV; v > 0; v--){
                    tempTotalSecs = tempTotalSecs * vowels.length;
                }
            }
            if (0!=numberV){
                for (int v = numberV; v > 0; v--){
                    tempTotalSecs = tempTotalSecs * digits.length;
                }
            }
            if(counter<=R){
                list1.add(tempTotalSecs);
                System.err.println("tempTotalSecs1:"+tempTotalSecs);
            }else if (counter>R){
                list1.add(tempTotalSecs);
                System.err.println("tempTotalSecs2:"+tempTotalSecs);
            }
            
        }
        if (!list2.isEmpty() || list2 == null){
            totalSecs = Collections.max(list1)+Collections.max(list2);
        }else{
            totalSecs = Collections.max(list1);
        }
        for (int i = 0; i < list1.size(); i += chunkSize) {
            chunkList.add(list1.subList(i, i + chunkSize >= list1.size() ? list1.size() : i + chunkSize));
        }
        System.err.println("chunkList:"+chunkList);
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(totalSecs);

	}

}
