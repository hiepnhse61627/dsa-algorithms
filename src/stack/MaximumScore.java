package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumScore {

  public static void main(String[] args) {
    maximumScore(new int[]{1,4,3,7,4,5}, 3);
  }

  public static int maximumScore(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();

    int[] left = new int[n];
    Arrays.fill(left, -1);

    // For moi phan tu i
    // tim left[i] la phan tu gan i nhat ben trai ma < nums[i]
    for (int i = 0; i < n; i++) {
      while(!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
        stack.removeLast();
      }

      if (!stack.isEmpty()) {
        left[i] = stack.peekLast();
      }

      stack.addLast(i);
    }

    stack = new ArrayDeque<>();

    // tim right[i] la phan tu gan i nhat ben phai ma < nums[i]
    int[] right = new int[n];
    Arrays.fill(right, n);

    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && nums[stack.peekLast()] >= nums[i]) {
        stack.removeLast();
      }

      if (!stack.isEmpty()) {
        right[i] = stack.peekLast();
      }

      stack.addLast(i);
    }

    // => subarray tu left[i] + 1 den right[i] - 1 chinh la subarray dai nhat chua i, nhan nums[i] la min
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (k > left[i] && k < right[i]) {
        result = Math.max(result, (right[i] - 1 - left[i]) *  nums[i]);
      }
    }

    return result;
  }
}
