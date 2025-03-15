package mainclass;

import java.util.stream.IntStream;

public class SelectionSort {

	public static void main(String[] args) {

		int nums[] = { 5, 7, 8, 2, 4, 9 };// {5,2,4,7,8,9}

		int index = 0;

		for (int k = nums.length; k > 1; k--) {
			int max = nums[0];
			for (int i = 1; i < k; i++) {
				if (max < nums[i]) {
					max = nums[i];
					index = i;
				}
			}
			int temp = nums[k - 1];
			nums[k - 1] = max;
			nums[index] = temp;
		}

		IntStream.of(nums).forEach(num -> System.out.print(num + ", "));
	}

}
