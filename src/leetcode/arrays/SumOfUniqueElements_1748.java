package leetcode.arrays;

/**
 * <a href="https://leetcode.com/problems/sum-of-unique-elements/">1748. Sum of Unique Elements</a>
 */
public class SumOfUniqueElements_1748 {

  public int sumOfUnique(int[] nums) {
    int[] count = new int[101];
    int answer = 0;

    for (int num : nums) {
      count[num] += 1;
    }

    for (int num : nums) {
      if (count[num] == 1) {
        answer += num;
      }
    }

    return answer;
  }
}
