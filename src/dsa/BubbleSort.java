package dsa;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BubbleSort {
	
	public static void main(String[] args) {
		int nums[] = {7,8,2,5,3,1};
		int count = 0;
		while(count<nums.length) {
			int i=0;
			int j = i+1;
			while(j<(nums.length - count)) {
				if(nums[i]> nums[j]) {
					int temp = nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
				i++;
				j++;
			}
			count++;
		}

		Stream.of(nums).forEach(num -> System.out.println(num));
		IntStream.of(nums).forEach(num -> System.out.println(num));
		
	}
}
