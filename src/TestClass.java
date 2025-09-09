import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.stream.IntStream;

public class TestClass {

  private static final int MOD = 1_000_000_007;
  private static long[] PREFIX_SUM;

  public static void main(String[] args) {
//    System.out.println(isPalindrome("aab", 1, 2));
    int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    IntStream.of(nums).boxed().sorted((a, b) -> b - a).mapToInt(Integer::intValue).toArray();

  }

  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static int maxSumMinProduct(int[] nums) {
    int n = nums.length;
    PREFIX_SUM = new long[n];
    int[] leftBoundary = new int[n]; // store the nearest lower index from the left
    int[] rightBoundary = new int[n]; // store the nearest lower index from the right
    Deque<Integer> deque = new ArrayDeque<>();
    long maxProduct = 0;

    // calculate prefix sum
    for (int i = 0; i < n; i++) {
      PREFIX_SUM[i] = i == 0 ? nums[i] : PREFIX_SUM[i - 1] + nums[i];
    }

    // Find nearest lower index from the left
    for (int i = 0; i < n; i++) {
      while (!deque.isEmpty() && nums[deque.getLast()] >= nums[i]) {
        deque.removeLast();
      }
      leftBoundary[i] = deque.isEmpty() ? -1 : deque.getLast();
      deque.addLast(i);
    }

    deque.clear();

    // Find nearest lower index from the right
    for (int i = n - 1; i >= 0; i--) {
      while (!deque.isEmpty() && nums[deque.getLast()] >= nums[i]) {
        deque.removeLast();
      }
      rightBoundary[i] = deque.isEmpty() ? n : deque.getLast();
      deque.addLast(i);
    }

    // Compute max product for each nums[i]
    for (int i = 0; i < n; i++) {
      maxProduct = Math.max(maxProduct, getSum(leftBoundary[i + 1], rightBoundary[i - 1]) * nums[i]);
    }

    return (int) (maxProduct % MOD);
  }

  private static long getSum(int left, int right) {
    return left == 0
        ? PREFIX_SUM[right]
        : PREFIX_SUM[right] - PREFIX_SUM[left - 1];
  }
}
