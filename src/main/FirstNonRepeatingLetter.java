package main;

import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatingLetter {

	public static void main(String[] args) {
		String str = "swiss";

		Map<Character, Long> charOccurence = str.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
		Character num = charOccurence.entrySet().stream().filter(ch -> ch.getValue() == 1).findFirst().get().getKey();
		System.out.println(num);
	}

}
