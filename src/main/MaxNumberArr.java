package main;
// 1 3 4 6 6 6 6 5 2 0

public class MaxNumberArr {
	public static void main(String[] args) {
		int[] num = { 1, 3, 7, 6, 6, 6, 6, 5, 2, 0 };
		int start = 0;
		int end = num.length - 1;
		System.out.println(binSearch(num, start, end));
	}
	/*
	 * num = { 1, 3, 4, 6, 6, 6, 6, 5, 2, 0 }; start = 0;0,3,3,6 end = 10;5,5,4,10
	 * mid = 5;2,4,3,
	 * 
	 * start = 0;0 5,5,5 end = 9;4,4 9,7,6 mid = 4;2,3 7,6,5
	 */
	private static int binSearch(int[] num, int start, int end) {
		if (start >= end) {
			return num[start];
		}
		int mid = ((end - start) / 2) + start;
		if (num[mid] > num[mid + 1]) {
			end = mid;
			return binSearch(num, start, end);
		} else if (num[mid] < num[mid + 1]) {
			start = mid + 1;
			return binSearch(num, start, end);
		} else {
			int leftMax = binSearch(num, start, mid);// 6
			int rightMax = binSearch(num, mid + 1, end);
			return Math.max(leftMax, rightMax);
		}
	}

}
