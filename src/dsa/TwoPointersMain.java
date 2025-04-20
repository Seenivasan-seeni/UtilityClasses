package dsa;

public class TwoPointersMain {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 4, 6, 8, 9, 14, 15 };
		int trgtNum = 29;

		int left = 0;
		int right = nums.length - 1;
		int i = 1;

		while (left < right) {
			System.out.println("Iteration num is " + i++);
			int sum = nums[left] + nums[right];
			if (sum > trgtNum) {
				right--;
			} else if (sum < trgtNum) {
				left++;
			} else {
				System.out.println("The sum of two number is " + nums[left] + " and " + nums[right]);
				break;
			}
		}

	}

	public static void main1(String[] args) {
		String str = "racecar";

		int left = 0;
		int right = str.length() - 1;
		boolean isPalindorme = true;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				isPalindorme = false;
				break;
			}
			left++;
			right--;
		}
		if (isPalindorme)
			System.out.println("It is a Palindrome String...");
		else
			System.out.println("It is not a Palindrome String");
	}

}
