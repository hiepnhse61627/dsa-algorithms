package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtracking {

  public static void main(String[] args) {
    System.out.println(partition("abcaa"));
  }

  public static List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> subset = new ArrayList<>();

    backtrack(0, s, result, subset);

    return result;
  }

  private static void backtrack(int start, String s, List<List<String>> list, List<String> subset) {
    if (start == s.length()) {
      list.add(new ArrayList<>(subset));
      return;
    }

    for (int i = start; i < s.length(); i++) {
      if (isPalindrome(s, start, i)) {
        subset.add(s.substring(start, i + 1));
        backtrack(i + 1, s, list, subset);
        subset.removeLast();
      }
    }
  }

  private static boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
      if (s.charAt(left++) != s.charAt(right--)) {
        return false;
      }
    }

    return true;
  }
}
