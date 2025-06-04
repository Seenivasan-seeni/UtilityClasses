package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondFrequentWord {

	public static void main(String[] args) {

		List<String> fruitsList = Arrays.asList("apple", "apple", "banana", "apple", "orange", "mango", "banana",
				"apple", "mango", "banana", "apple");

		Map<String, Long> fruitsMap = fruitsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(fruitsMap);

		System.out.println(fruitsMap.entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue().reversed())
				.skip(1).findFirst());

	}

}
