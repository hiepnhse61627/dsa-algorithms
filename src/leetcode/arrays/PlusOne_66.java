package leetcode.arrays;

/**
 * <p>
 * Problem Link:
 * <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>
 */
public class PlusOne_66 {
  /**
   * [1, 2, 3] => [1, 2, 4]
   * [1, 2, 9] => [1, 3, 0]
   * [1, 9, 9] => [2, 0, 0]
   * [9, 9, 9] => [1, 0, 0, 0]
   *
   * Approach:
   * Traverse list from the end:
   * - When digit < 9, add 1 and return immediately.
   *   i.e: [1, 2, 3] => [1, 2, 4]
   * - When digit == 9, set to 0.
   *   i.e: [1, 9, 9] => [1, 9, 0] => [1, 0, 0] => [2, 0, 0]
   * Case [9, 9, 9], after the loop, the array will be [0, 0, 0]
   * We need to initiate a new array with digits.length + 1 and set first element to 0
   *
   */
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits; // return immediately
      } else {
        digits[i] = 0;
      }
    }

    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }
}
