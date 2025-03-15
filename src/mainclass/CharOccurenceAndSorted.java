package mainclass;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class CharOccurenceAndSorted {

	public static void main(String[] args) {
		String s = "JavaDeveloper";

		Map<Character, Long> charMap = s.toLowerCase().chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		List<Entry<Character, Long>> map = charMap.entrySet().stream().sorted((i1, i2) -> {
			if (i1.getValue() < i2.getValue()) {
				return 1;
			} else if (i1.getValue() > i2.getValue()) {
				return -1;
			}
			return 0;
		}).peek(rt -> System.out.println(rt))
				.collect(Collectors.toList());
		
		System.out.println(map);
	}
}
