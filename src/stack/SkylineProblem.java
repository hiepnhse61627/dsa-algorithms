package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SkylineProblem {

  public static void main(String[] args) {
    int[] nums = new int[]{8, 3, 4, 3, 5, 9};
    System.out.println(skylineStack(nums));
  }

  // Time: O(N^2)
  // Space: O(1)
  public static List<Integer> skyline(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int j = i - 1;
      while (j >= 0 && nums[j] <= nums[i]) {
        j--;
      }
      result.add(j);
    }

    return result;
  }

  public static List<Integer> skylineStack(int[] nums) {
    int n = nums.length;
    List<Integer> result = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i]) {
        stack.removeLast();
      }

      result.add(stack.isEmpty() ? -1 : stack.peekLast());

      stack.addLast(i);
    }

    return result;
  }
}
