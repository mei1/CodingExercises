package org.qimei.codingGames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GetNumberCloserToZero {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        // int[] allTemp = in;
        // System.err.println("allTemp:"+allTemp);
        int t = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            list.add(t);
        }
        // list.add(0);
        System.err.println("list:"+list);
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int near = 0;
        if (!list.isEmpty()){
            int curr = 0;
            near = list.get(0); 
            Collections.sort(list);
            System.err.println("sorted list1:"+list);
            System.err.println("near1:"+near);
            for (int i=0; i < list.size(); i++){
                System.err.println("dist from " + list.get(i) + " = " + Math.abs(0 -list.get(i)));
                curr = list.get(i) * list.get(i); 
                System.err.println("curr:"+curr);
                System.err.println("near2:"+near);
                if (curr <= (near * near))  { 
                    near = list.get(i);
                    System.err.println("near3:"+near);
                } 
            }   
        }else{
            near = 0;
        }
        
        System.out.println(near);

	}

}
