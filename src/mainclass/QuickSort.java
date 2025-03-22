package mainclass;

import java.util.stream.IntStream;

public class QuickSort {

//	public static void main(String[] args) {
//		int[] arr = { 3, 7, 8, 2, 1, 10, 5, 100 };
//		quickSort(arr, 0, arr.length - 1);
//	}
//
//	public static void quickSort(int[] arr, int low, int high) {
//		if (low < high) {
//			// Find partition index
//			int pi = partition(arr, low, high);
//
//			// Recursively sort elements before and after partition
//			quickSort(arr, low, pi - 1);
//			quickSort(arr, pi + 1, high);
//		}
//	}
//
//	// Partition function to place pivot element at correct position
//	public static int partition(int[] arr, int low, int high) {
//		int pivot = arr[high];
//		int i = (low - 1);
//
//		for (int j = low; j < high; j++) {
//			if (arr[j] <= pivot) {
//				i++;
//				// Swap arr[i] and arr[j]
//				int temp = arr[i];
//				arr[i] = arr[j];
//				arr[j] = temp;
//			}
//		}
//
//		// Swap arr[i + 1] and arr[high] (pivot)
//		int temp = arr[i + 1];
//		arr[i + 1] = arr[high];
//		arr[high] = temp;
//
//		IntStream.of(arr).forEach(num -> System.out.print(num + ", "));
//		System.out.println();
//
//		return i + 1;
//	}

	public static void main(String[] args) {
		int nums[] = { 3, 7, 8, 2, 1, 10, 5, 100 };// 3,2,1,5,7,8,10

		int low = 0;
		int high = nums.length - 1;

		sort(nums, low, high);

	}

	private static void sort(int[] nums, int low, int high) { // [3,2,1] ,0 ,2
		if (low > high) {
			return;
		}

		int mtp = low - 1;

		for (int j = low; j < high; j++) {
			if (nums[j] < nums[high]) {
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
