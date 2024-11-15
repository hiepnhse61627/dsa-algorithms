package dynamic_programming.leetcode_exercises;

public class FindLongestString {

  public static String findLongestString(String[] stringList) {
    if (stringList == null || stringList.length == 0) {
      return "";
    }

    int max = stringList[0].length();
    int i = 0;
    for (String s : stringList) {
      if (s.length() > max) {
        max = s.length();
        i++;
      }
    }

    return stringList[i];
  }

  public static String findLongestString2(String[] stringList) {
    String longestString = "";
    for (String str : stringList) {
      if (str.length() > longestString.length()) {
        longestString = str;
      }
    }
    return longestString;
  }

  public static void main(String[] args) {
    String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
    String longest1 = findLongestString(stringList1);
    System.out.println("Test case 1: Longest string: " + longest1);  // prints "banana"

    String[] stringList2 = {"cat", "giraffe", "elephant", "hippopotamus"};
    String longest2 = findLongestString(stringList2);
    System.out.println("Test case 2: Longest string: " + longest2);  // prints "hippopotamus"

    String[] stringList3 = {"sun", "moon", "planet", "universe"};
    String longest3 = findLongestString(stringList3);
    System.out.println("Test case 3: Longest string: " + longest3);  // prints "universe"

    String[] stringList4 = {"java", "python", "javascript", "c"};
    String longest4 = findLongestString(stringList4);
    System.out.println("Test case 4: Longest string: " + longest4);  // prints "javascript"

    String[] stringList5 = {"", "a", "aa", "aaa"};
    String longest5 = findLongestString(stringList5);
    System.out.println("Test case 5: Longest string: " + longest5);  // prints "aaa"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Longest string: banana
            Test case 2: Longest string: hippopotamus
            Test case 3: Longest string: universe
            Test case 4: Longest string: javascript
            Test case 5: Longest string: aaa
        */

  }
}
