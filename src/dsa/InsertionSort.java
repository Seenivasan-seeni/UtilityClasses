package dsa;

import java.util.stream.IntStream;

public class InsertionSort {

	public static void main(String[] args) {

		int num[] = { 6, 4, 7, 2, 9, 10, 3, 99, 100 };// 4,6,7,2,9,10,3

		for (int i = 1; i < num.length; i++) {
			int temp = num[i];
			int numShiftIndex = i;
			for (int j = i - 1; j >= 0; j--) {
				if (num[j] > temp) {
					num[numShiftIndex] = num[j];
					numShiftIndex--;
				}
			}
			num[numShiftIndex] = temp;
		}
		IntStream.of(num).forEach(nums -> System.out.print(nums + ", "));
	}

}
