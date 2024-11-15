package dynamic_programming.leetcode_exercises;

import java.util.Arrays;

public class RemoveDuplicates {

  public static int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int i = 1;
    int occurrence = nums[0];

    for (int j = 1; j < nums.length; j++) {
      if (nums[j] != occurrence) {
        nums[i] = nums[j];
        occurrence = nums[j];
        i++;
      }
    }

    return i;
  }

  public static int removeDuplicate2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int writePointer = 1;

    for (int readPointer = 1; readPointer < nums.length; readPointer++) {
      if (nums[readPointer] != nums[readPointer - 1]) {
        nums[writePointer] = nums[readPointer];
        writePointer++;
      }
    }

    return writePointer;
  }

  public static void main(String[] args) {

    int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    int newLength1 = removeDuplicate2(nums1);
    System.out.println("Test case 1: New length: " + newLength1);
    System.out.println("Test case 1: Unique values in list: " + Arrays.toString(
        Arrays.copyOfRange(nums1, 0, newLength1)));

    int[] nums2 = {1, 1, 2};
    int newLength2 = removeDuplicates(nums2);
    System.out.println("Test case 2: New length: " + newLength2);
    System.out.println("Test case 2: Unique values in list: " + Arrays.toString(
        Arrays.copyOfRange(nums2, 0, newLength2)));

    int[] nums3 = {-1, 0, 0, 0, 3, 3};
    int newLength3 = removeDuplicates(nums3);
    System.out.println("Test case 3: New length: " + newLength3);
    System.out.println("Test case 3: Unique values in list: " + Arrays.toString(
        Arrays.copyOfRange(nums3, 0, newLength3)));

    int[] nums4 = {};
    int newLength4 = removeDuplicates(nums4);
    System.out.println("Test case 4: New length: " + newLength4);
    System.out.println("Test case 4: Unique values in list: " + Arrays.toString(
        Arrays.copyOfRange(nums4, 0, newLength4)));

    int[] nums5 = {1, 1, 1, 1, 1};
    int newLength5 = removeDuplicates(nums5);
    System.out.println("Test case 5: New length: " + newLength5);
    System.out.println("Test case 5: Unique values in list: " + Arrays.toString(
        Arrays.copyOfRange(nums5, 0, newLength5)));

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: New length: 5
            Test case 1: Unique values in list: [0, 1, 2, 3, 4]
            Test case 2: New length: 2
            Test case 2: Unique values in list: [1, 2]
            Test case 3: New length: 3
            Test case 3: Unique values in list: [-1, 0, 3]
            Test case 4: New length: 0
            Test case 4: Unique values in list: []
            Test case 5: New length: 1
            Test case 5: Unique values in list: [1]
        */

  }
}
