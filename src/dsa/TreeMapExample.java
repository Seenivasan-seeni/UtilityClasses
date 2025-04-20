package dsa;

import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("Seeni", 1);
		treeMap.put("Murali", 6);
		treeMap.put("Zanveer", 4);
		treeMap.put("Sibi", 3);
		
		for (String string : treeMap.keySet()) {
			System.out.println(treeMap.get(string));
			
		}
		
	}
}
