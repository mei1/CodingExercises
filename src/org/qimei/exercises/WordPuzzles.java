package org.qimei.codingGames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class WordPuzzles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        String aToZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ?"; //to get all alphabet in the same string to be identified by index
        System.err.println("H:"+H+", W:"+L); //to know the H and W of the required printout ASCII size
        if (in.hasNextLine()) {
            in.nextLine();
        }
        // String alphabet = null;
        String T = in.nextLine();
        int index = 0;
        List<String> list = new ArrayList<>(Arrays.asList(T.toUpperCase().split("")));
        List<Integer> totalIndex = new ArrayList<>();
        
        System.err.println("T:"+T);
        System.err.println("list:"+list);
        StringBuilder sb = new StringBuilder();
        String rowStr= null;
        int totalLength = list.size()*L;
        HashMap<Integer, String> hMap = new HashMap();
        // System.err.println("totalLength:"+totalLength);
        
        for (int i = 0; i < T.length(); i++) {
            String charStr = Character.toString(T.toUpperCase().charAt(i));
            // System.err.println("charStr:"+charStr);
            index = aToZ.indexOf(charStr);
            // System.err.println("index:"+index);
            totalIndex.add(index);
        }
        System.err.println("totalIndex:"+totalIndex);
        for (int i = 0; i < H; i++) {
            List<String> strings = new ArrayList<String>();
            int index1 = 0;
            String ROW = in.nextLine();
            System.err.println(ROW);
            while (index1 < ROW.length()) {
                strings.add(ROW.substring(index1, Math.min(index1 + L,ROW.length())));
                index1 += L;
            }
            
            String printOut = null;
            List<String> wordsList = new ArrayList<String>();
            for (int a = 0; a < totalIndex.size(); a++){
                int idx = totalIndex.get(a);
                // System.err.println("idx:"+idx);
                // System.err.println(strings.get(idx));
                if (idx>=0){
                    wordsList.add(strings.get(idx));
                }else{
                    wordsList.add(strings.get(strings.size()-1));
                }
                
            }
            printOut = String.join("", wordsList);
            System.out.println(printOut);
        }

	}

}
