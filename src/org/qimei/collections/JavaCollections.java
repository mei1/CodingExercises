package org.qimei.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.qimei.java.model.Movie;
import org.qimei.java.model.Person;

public class JavaCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		//setting size to an arraylist
		List<String> limitedList = new ArrayList<>(20);
		
		List<Long> longList = new ArrayList<>();
		
		// adding list
		longList.add(1L);
		longList.add(2L);
		longList.add(1, 3L);
		System.out.println("complete longList:"+longList);
		
		// iterating the List
		ListIterator<String> it = list.listIterator(list.size());
		List<String> result = new ArrayList<>(list.size());
		while(it.hasPrevious()) {
			result.add(it.previous());
		}
		System.out.println("result after iterating the list:"+result);
		Collections.reverse(list);
		
		//searching an unsorted array
		List<String> stringsToSearch = new ArrayList<>(list);
		Iterator<String> it1 = stringsToSearch.iterator();
		Set<String> matchingStrings = new HashSet<>(Arrays.asList("a", "c", "9"));
		
		List<String> result1 = new ArrayList<>();
		while (it1.hasNext()) {
			String s = it.next();
			if (matchingStrings.contains(s)) {
				result1.add(s);
			}
		}
		System.out.println("result from searching unsorted array:"+result1);
		
		Set<String> hashSet = new HashSet<>();
		hashSet.add("string added");
		if(hashSet.contains("string added")){
			System.out.println("string added: true");
		}
		hashSet.remove("string added");
		hashSet.clear();
		System.out.println("hashSet size after clear:"+hashSet.size());
		
		//check if hashSet is empty
		if(hashSet.isEmpty()){
			System.out.println("hashSet is empty");
		}
		
		Iterator<String> itr= hashSet.iterator();
		while(itr.hasNext()){
			System.out.println("itr hashSet:"+itr.next());
		}
		
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(5, "A");
		hashMap.put(11, "C");
		hashMap.put(4, "Z");
		hashMap.put(77, "Y");
        hashMap.put(9, "P");
        hashMap.put(66, "Q");
        hashMap.put(0, "R");
        System.out.println("hashMap:"+hashMap);
        
        System.out.println("before sorting:");
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
        	Map.Entry entry = (Map.Entry) iterator.next();
        	System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map<Integer, String> map = new TreeMap<Integer, String>(hashMap);
        System.out.println("after sorting:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while(iterator2.hasNext()){
        	Map.Entry entry2 = (Map.Entry) iterator2.next();
        	System.out.println(entry2.getKey() + ": " + entry2.getValue());
        }
		
        //convert collections
        System.out.println("convert list to array...");
        List<Integer> sourceList = Arrays.asList(0, 1, 2, 3, 4, 5);
        System.out.println("list:"+sourceList);
        Integer[] targetArray = sourceList.toArray(new Integer[sourceList.size()]);
        System.out.println("array:"+targetArray);
        
        System.out.println("convert array to list...");
        Integer[] sourceArray = {6, 7, 8, 9, 10};
        System.out.println("array:"+sourceArray);
        List<Integer> targetList = Arrays.asList(sourceArray);
        System.out.println("list:"+targetList);
        
        //combine lists
        List<Integer> combineList = Stream.of(sourceList, targetList)
        		.flatMap(Collection::stream)
        		.collect(Collectors.toList());
        System.out.println("combine lists of int:"+combineList);
        
        System.out.println("convert array to set...");
        Set<Integer> targetSet = new HashSet<Integer>(Arrays.asList(sourceArray));
        System.out.println("set:"+targetSet);
        
        System.out.println("sorting an array...");
        int[] toSort = new int[] { 5, 1, 89, 255, 7, 88, 200, 123, 66 };
		
		//sorting the entire array
		Arrays.sort(toSort);
		System.out.println("sorted array:"+toSort);
		
		//sorting part of an array: Arrays.sort(int[] a, int fromIndex, int toIndex)
		Arrays.sort(toSort, 3, 7);
		System.out.println("sorted part of array:"+toSort);
		
        //sort a list of String alphabetically
		List<String> cities = Arrays.asList("Milan", "london", "Sydney", "Tokyo", "New York");
		cities.sort(String.CASE_INSENSITIVE_ORDER);
		System.out.println("case insensitive order:"+cities); //list is sorted in case-insensitive alphabetically order
		
		cities.sort(Comparator.naturalOrder());
		System.out.println("natural order:"+cities); //list is sorted by placing capital letters first
		
		//copy from one list to another (entire list)
		List<String> cities2 = cities.stream().collect(Collectors.toList());
		System.out.println("copy entire list of cities:"+cities2);
		
		//copy from one list to another skipping one or more elements
		List<String> cities3 = cities.stream().skip(1).collect(Collectors.toList());
		System.out.println("copy list of cities:"+cities3);
		
		//sort a list of Integers
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(9);
		numList.add(5);
		numList.add(4);
		numList.add(8);
		numList.sort(Comparator.naturalOrder());
		System.out.println("sorted numbers1:"+numList);
		
		List<Integer> numbers = Arrays.asList(6, 2, 1, 4, 9);
		numbers.sort(Comparator.naturalOrder());
		System.out.println("sorted numbers:"+numbers);
		
		//sort a list by string field
		List<Person> people = Arrays.asList(new Person("Joe", 48), new Person("Mary", 30), new Person("Mike", 73));
		people.sort(Comparator.comparing(Person::getAge)); //compare based on the criteria (Object::Method)
		people.forEach(System.out::println);
		
		//sort a list by double field
		List<Movie> movies = Arrays.asList(new Movie("Lord of the rings", 8.8), new Movie("Back to the future", 8.5),
				new Movie("Carlito's way", 7.9), new Movie("Pulp fiction", 8.9));
		movies.sort(Comparator.comparingDouble(Movie::getRating).reversed()); //invert default natural-order that is from lowest to highest.
		movies.forEach(System.out::println);
		
		
		
		Scanner in = new Scanner(System.in);
        
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        HashMap<String, String> associationTable = new HashMap(); // Collect association table into hashmap
        ArrayList<String> testFileNames = new ArrayList(); // collect all input files to a list
        String tmpFileName = null; // var to be used for each test input filename
        String tmpExtn = null; // var to store the extn for each test input file name
        String output = null; // var to store output for each test input file name
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            String[] parts = EXT.split("", 5);
            associationTable.put(EXT.toLowerCase(), MT); // One of the conditions is to correctly map both upper case and lower case extensions, so better store them all in lower case
        }
        
        in.nextLine();
        
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            testFileNames.add(FNAME);
        }
        
        
        // print all inputs to ensure all the correct input data is collected
        System.err.println("N - " + N);
        System.err.println("Q - " + Q);
        System.err.println("associationTable - " + associationTable);
        System.err.println("testFileNames - " + testFileNames.size());
        
        for (int i =0; i < testFileNames.size(); i++) {
            
            tmpFileName = testFileNames.get(i);
            
            // extn can be found using the last index of the dot in file name and the total length of the file name
            tmpExtn = tmpFileName.substring(tmpFileName.lastIndexOf(".") + 1, tmpFileName.length());
            
            System.err.println(i + " / " + testFileNames.size() + " - " + testFileNames.get(i) + " | " + tmpExtn);
            
            // Conditions for successful file extn -
            // 1. there should be atleast one dot "." i file name
            // 2. extn should not be null or empty
            // 3. // One of the conditions is to correctly map both upper case and lower case extensions, so better store them all in lower case
            // 4. If the extn is found in hashmap, thats the output, else its unknown
            
            if (-1 != tmpFileName.lastIndexOf(".") && null != tmpExtn && 
                        "" != tmpExtn && associationTable.containsKey(tmpExtn.toLowerCase())) {
                output = associationTable.get(tmpExtn.toLowerCase());
            } else {
                output = "UNKNOWN";
            }
            
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
            System.out.println(output);
            
        }
		
	}
}
