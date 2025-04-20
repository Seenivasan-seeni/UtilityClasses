package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenNumberSquareMain {

	public static void main(String[] args) {
		int[] num = { 5, 9, 2, 6, 4, 2, 7, 10, 8 };

		List<Integer> numList = IntStream.of(num).filter(i -> i % 2 == 0).map(x -> x * x).boxed().collect(Collectors.toList());
//		Arrays.stream(num).filter(i -> i % 2 == 0).map(x -> x*x).boxed().collect(Collectors.toList());
		System.out.println(numList);
	}

}
