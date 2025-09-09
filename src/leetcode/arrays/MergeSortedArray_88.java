package leetcode.arrays;

import java.util.Arrays;

/**
 * <p>Leetcode problem: <a href="https://leetcode.com/problems/merge-sorted-array/">Merge Sorted
 * Array</a></p>
 *
 * <p><strong>Problem Example:</strong></p>
 * <pre>
 * Input:
 * nums1 = [1, 2, 3, 0, 0, 0]
 * nums2 = [2, 5, 6]
 *
 * Output:
 * [1, 2, 2, 3, 5, 6]
 * </pre>
 *
 * <p><strong>Optimized Solution: Two-Pointer Merge Sort Technique</strong></p>
 * <p>
 * The idea is to merge two sorted arrays in such a way that the merged array remains sorted after
 * the merge. This method achieves a time complexity of O(m + n), where {@code m} and {@code n} are
 * the lengths of {@code nums1} and {@code nums2} respectively.
 * </p>
 *
 * <p><strong>Example Implementation:</strong></p>
 * <pre>
 * int[] mergedArray = new int[m + n];
 * int i = 0, j = 0, k = 0;
 *
 * // Merge elements from nums1 and nums2 into mergedArray
 * while (i < m && j < n) {
 *     if (nums1[i] < nums2[j]) {
 *         mergedArray[k] = nums1[i];
 *         i++;
 *     } else {
 *         mergedArray[k] = nums2[j];
 *         j++;
 *     }
 *     k++;
 * }
 *
 * // Copy remaining elements from nums1, if any
 * while (i < m) {
 *     mergedArray[k] = nums1[i];
 *     i++;
 *     k++;
 * }
 *
 * // Copy remaining elements from nums2, if any
 * while (j < n) {
 *     mergedArray[k] = nums2[j];
 *     j++;
 *     k++;
 * }
 * </pre>
 *
 * <p><strong>Note:</strong></p>
 * <p>
 * For this problem, since {@code nums1} has enough space at the end to accommodate {@code nums2},
 * we can further optimize the solution by merging from the end of both arrays to avoid using extra
 * space.
 * </p>
 * <p><strong>Example Implementation:</strong></p>
 * <pre>
 * // nums1 = [1,2,3,0,0,0], m = 3
 * //              i     k
 * // nums2 = [2,5,6], n = 3
 * //              j
 *
 * int i = m - 1;
 * int j = n - 1;
 * int k = m + n - 1;
 *
 * while (i >= 0 && j >= 0) {
 *    if (nums1[i] > nums2[j]) {
 *        nums1[k] = nums1[i];
 *        i--;
 *    } else {
 *        nums1[k] = nums2[j];
 *        j--;
 *    }
 *    k--;
 * }
 *
 * while (j >= 0) {
 *    nums1[k] = nums2[j];
 *    j--;
 *    k--;
 * }
 */
public class MergeSortedArray_88 {

  public static void main(String[] args) {
    merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (i >= 0 && j >= 0) {
      if (nums1[i] > nums2[j]) {
        nums1[k] = nums1[i];
        i--;
      } else {
        nums1[k] = nums2[j];
        j--;
      }
      k--;
    }

    while (j >= 0) {
      nums1[k] = nums2[j];
      j--;
      k--;
    }

    System.out.println(Arrays.toString(nums1));
  }
}
