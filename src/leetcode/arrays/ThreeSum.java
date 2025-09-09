package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    int numsLength = nums.length;

    Arrays.sort(nums);

    for (int fixed = 0; fixed < numsLength; fixed++) {
      int left = fixed + 1;
      int right = numsLength - 1;

      while (left < right) {
        int sum = nums[left] + nums[right];

        if (sum == -nums[fixed]) {
          list.add(List.of(nums[left], nums[right], nums[fixed]));
        }

        left++;
        right--;
      }
    }

    return list;
  }
}
