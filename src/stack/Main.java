package stack;

public class Main {

  public static void main(String[] args) {
    StackArray<Integer> stack = new StackArray<>();
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(2);

    System.out.println("Before sorting:");
    stack.printStack();

    sortStack(stack);

    System.out.println("\nAfter sorting:");
    stack.printStack();
  }

  private static String reverseString(String s) {
    StackArray<Character> stack = new StackArray<>();
    StringBuilder reversed = new StringBuilder();

    for (char c : s.toCharArray()) {
      stack.push(c);
    }

    while (!stack.isEmpty()) {
      reversed.append(stack.pop());
    }

    return reversed.toString();
  }

  private static boolean isBalancedParentheses(String s) {
    StackArray<Character> stack = new StackArray<>();

    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }

    }

    return stack.isEmpty();
  }

  private static void sortStack(StackArray<Integer> stack) {
    StackArray<Integer> additionalStack = new StackArray<>();

    while (!stack.isEmpty()) {
      Integer temp = stack.pop();

      while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
        stack.push(additionalStack.pop());
      }

      additionalStack.push(temp);
    }

    while (!additionalStack.isEmpty()) {
      stack.push(additionalStack.pop());
    }
  }

  private static void testAndPrint(String testStr, boolean expected) {
    // Run the test and store the result
    boolean result = isBalancedParentheses(testStr);

    // Print the test string, expected result, and actual result
    System.out.println("Test String: " + testStr);
    System.out.println("EXPECTED: " + expected);
    System.out.println("RESULT: " + result);

    // Check if the test passed or failed
    if (result == expected) {
      System.out.println("STATUS: PASS");
    } else {
      System.out.println("STATUS: FAIL");
    }

    // Print a separator for better readability
    System.out.println("--------------");
  }
}
