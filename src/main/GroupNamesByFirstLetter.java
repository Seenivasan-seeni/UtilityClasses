package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupNamesByFirstLetter {
	
	public static void main(String[] args) {
		String[] names = {"Alice", "Aaron", "Bob", "Brandon", "Charlie"};
		
		Map<String, List<String>> nameGroup = Arrays.stream(names).collect(Collectors.groupingBy(name -> name.substring(0, 1)));
		System.out.println(nameGroup);
	}

}
