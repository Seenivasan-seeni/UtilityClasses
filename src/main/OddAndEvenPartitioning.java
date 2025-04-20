package main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OddAndEvenPartitioning {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 7, 8, 5, 6, 2, 1 };

		Map<Boolean, List<Integer>> map = IntStream.of(nums).boxed()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		map.forEach((isEven, num) -> System.out.println((isEven?"Even":"Odd") + " Numbers: " + num));
	}

}
