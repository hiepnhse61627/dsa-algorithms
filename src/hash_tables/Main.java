package hash_tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
//    HashTable myHashTable = new HashTable();
//
//    myHashTable.set("nails", 100);
//    myHashTable.set("tile", 50);
//    myHashTable.set("lumber", 80);
//
//    myHashTable.set("bolts", 200);
//    myHashTable.set("screws", 140);
//
//    myHashTable.printTable();
//
//    System.out.println(myHashTable.get("lumber"));
//    System.out.println(myHashTable.get("bolts"));
//    System.out.println(myHashTable.get("invalid"));
//
//    System.out.println(myHashTable.keys());
//
//    int[] array1 = {1, 3, 5};
//    int[] array2 = {2, 4, 5};
//
//    System.out.println(itemInCommon(array1, array2));
//    System.out.println(itemInCommon2(array1, array2));

//    System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

//    System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
//    System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
//    System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
//    System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
//    System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
//    System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
//    System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

//    int[] nums1 = {1, 2, 3, 4, 5};
//    int target1 = 9;
//    int[] result1 = subarraySum(nums1, target1);
//    System.out.println("[" + result1[0] + ", " + result1[1] + "]");
//
//    int[] nums2 = {-1, 2, 3, -4, 5};
//    int target2 = 0;
//    int[] result2 = subarraySum(nums2, target2);
//    System.out.println("[" + result2[0] + ", " + result2[1] + "]");
//
//    int[] nums3 = {2, 3, 4, 5, 6};
//    int target3 = 3;
//    int[] result3 = subarraySum(nums3, target3);
//    System.out.println("[" + result3[0] + ", " + result3[1] + "]");
//
//    int[] nums4 = {};
//    int target4 = 0;
//    int[] result4 = subarraySum(nums4, target4);
//    System.out.println("[]");

//    List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
//    List<Integer> newList = removeDuplicates(myList);
//    System.out.println(newList);

//    System.out.println(hasUniqueChars("abcdefg")); // should return true
//    System.out.println(hasUniqueChars("hello")); // should return false
//    System.out.println(hasUniqueChars("")); // should return true
//    System.out.println(hasUniqueChars("0123456789")); // should return true
//    System.out.println(hasUniqueChars("abacadaeaf")); // should return false

//    int[] arr1 = {1, 2, 3, 4, 5};
//    int[] arr2 = {2, 4, 6, 8, 10};
//    int target = 7;
//
//    List<int[]> pairs = findPairs(arr1, arr2, target);
//    for (int[] pair : pairs) {
//      System.out.println(Arrays.toString(pair));
//    }

    testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
    testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
    testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
    testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
    testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
    testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
    testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
    testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
    testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);
  }

  public static boolean itemInCommon(int[] array1, int[] array2) {
    for (int i : array1) {
      for (int j : array2) {
        if (i == j) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean itemInCommon2(int[] array1, int[] array2) {
    HashMap<Integer, Boolean> myHashMap = new HashMap<>();

    for (int i : array1) {
      myHashMap.put(i, true);
    }

    for (int j : array2) {
      if (myHashMap.get(j) != null) {
        return true;
      }
    }

    return false;
  }

  public static List<Integer> findDuplicates(int[] array) {
//    return Arrays.stream(array)
//        .boxed()
//        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//        .entrySet()
//        .stream()
//        .filter(entry -> entry.getValue() > 1)
//        .map(Map.Entry::getKey)
//        .collect(Collectors.toList());

    List<Integer> duplicates = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : array) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > 1) {
        duplicates.add(entry.getKey());
      }
    }

    return duplicates;
  }

  public static Character firstNonRepeatingChar(String str) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    for (char c : str.toCharArray()) {
      if (map.get(c) == 1) {
        return c;
      }
    }

    return null;
  }

  public static List<List<String>> groupAnagrams(String[] strings) {
    Map<String, List<String>> anagramGroups = new HashMap<>();
    for (String s : strings) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String canonical = String.valueOf(chars);
      if (anagramGroups.containsKey(canonical)) {
        anagramGroups.get(canonical).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        anagramGroups.put(canonical, list);
      }
    }

    return new ArrayList<>(anagramGroups.values());
  }

  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{};
  }

  public static int[] subarraySum(int[] nums, int target) {
    Map<Integer, Integer> sumIndex = new HashMap<>();
    int currentSum = 0;
    sumIndex.put(0, -1);

    /*
      {-1, 2, 3, -4, 5} - target: 0
      1:
         currentSum = -1;
         temp = -1 - 0 = -1
         sumIndex: {-1, 0}
      2:
         currentSum = -1 + 2 = 1;
         temp = 1 - 0 = 1
         sumIndex: {-1, 0}, {1, 1}
      3:
         currentSum = 1 + 3 = 4
         temp = 4 - 0 = 4
         sumIndex: {-1, 0}, {1, 1}, {3, 2}
      4:
         currentSum = 4 + (-4) = 0
         temp = 0 - 0 = 0 (*)
         return {1, 3}
     */
    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      int temp = currentSum - target;
      if (sumIndex.containsKey(temp)) {
        return new int[]{sumIndex.get(temp) + 1, i};
      }
      sumIndex.put(currentSum, i);
    }

    return new int[]{};
  }

  public static List<Integer> removeDuplicates(List<Integer> nums) {
    Set<Integer> set = new HashSet<>(nums);
    return new ArrayList<>(set);
  }

  public static boolean hasUniqueChars(String s) {
    Set<Character> set = new HashSet<>();

    for (char c : s.toCharArray()) {
      if (!set.add(c)) {
        return false;
      }
    }

    return true;
  }

  public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
    List<int[]> pairs = new ArrayList<>();
    Set<Integer> set = Arrays.stream(arr1)
        .boxed()
        .collect(Collectors.toSet());

    for (int i : arr2) {
      int temp = target - i;
      if (set.contains(temp)) {
        pairs.add(new int[]{i, temp});
      }
    }

    return pairs;
  }

  public static int longestConsecutiveSequence(int[] arr) {
    Set<Integer> numSet = new HashSet<>();

    for (int num : arr) {
      numSet.add(num);
    }

    int longestStreak = 0;
    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int currentNum = num;
        int currentStreak = 1;
        while (numSet.contains(currentNum + 1)) {
          currentNum++;
          currentStreak++;
        }
        longestStreak = Math.max(longestStreak, currentStreak);
      }
    }

    return longestStreak;
  }

  private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
    System.out.println("Test: " + title);
    System.out.print("Testing array: ");
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();

    int result = longestConsecutiveSequence(nums);
    System.out.println("Expected longest streak: " + expected);
    System.out.println("Actual longest streak: " + result);

    if (result == expected) {
      System.out.println("PASS\n");
    } else {
      System.out.println("FAIL\n");
    }
  }
}
