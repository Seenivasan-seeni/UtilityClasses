package mainclass;

import java.util.stream.IntStream;

public class QuickSort {

	public static void main(String[] args) {
		int nums[] = { 3, 7, 8, 2, 1, 10, 5, 100 };// 3,2,1,5,7,8,10

		int low = 0;
		int high = nums.length - 1;

		sort(nums, low, high);

	}

	private static void sort(int[] nums, int low, int high) { // [3,2,1] ,0 ,2
		if (low >= high) {
			return;
		}
		int pivot = nums[high];
		int mtp = low - 1;

		for (int j = low; j < high; j++) {
			if (nums[j] <= pivot) {
				mtp++;
				int temp = nums[mtp];
				nums[mtp] = nums[j];
				nums[j] = temp;
			}
		}
		mtp++;
		int temp = nums[mtp];
		nums[mtp] = nums[high];
		nums[high] = temp;

		IntStream.of(nums).forEach(num -> System.out.print(num + ", "));
		System.out.println();

		sort(nums, low, mtp - 1);
		sort(nums, mtp + 1, high);

	}
}
