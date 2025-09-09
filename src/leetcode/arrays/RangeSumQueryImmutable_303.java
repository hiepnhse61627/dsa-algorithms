package leetcode.arrays;

/**
 * <a href="https://leetcode.com/problems/range-sum-query-immutable/">303. Range Sum Query - Immutable</a>
 */
public class RangeSumQueryImmutable_303 {

  private int[] prefixSum;

  /**
   * [-2,0,3,-5,2,-1]
   * [-2,-2,1,-4,-2,-3]
   */
  public RangeSumQueryImmutable_303(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i] + nums[i - 1];
    }

    prefixSum = nums;
  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return prefixSum[right];
    }
    return prefixSum[right] - prefixSum[left - 1];
  }
}
