package org.qimei.exercises;

import java.io.*;
import java.util.*;

public class CompareNumber {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int bobScore = 0;
        int aliceScore = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            int numA = a.get(i);
            int numB = b.get(i);
            if (numA>numB){
                aliceScore++;
            } else if (numA<numB){
                bobScore++;
            }
        }
        list.add(aliceScore);
        list.add(bobScore);
        return list;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(null);
//        BufferedWriter bufferedWriter = new BufferedWriter(null);

//        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(6);
        a.add(7);

        /*for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        */
        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(6);
        b.add(10);
        /*for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }*/

        List<Integer> result = compareTriplets(a, b);
        System.out.println("result:"+result);
        /*for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}
