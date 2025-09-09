package leetcode.arrays;

/**
 * <p>
 * Problem Link:
 * <a href="https://leetcode.com/problems/remove-element/">27. Remove Element</a>
 */
public class RemoveElement_27 {

  /**
   * Approach
   * Init k = 0 to keep track of the first k elements in the array which are not equal to val
   * Traverse through nums array
   * - When element is not equal to value, set the value at position k.
   * When the loop ends, return k which represents the length of the modified array
   */
  public int removeElement(int[] nums, int val) {
    int k = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        k++;
      }
    }

    return k;
  }
}
