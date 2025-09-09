package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CalculationProblem {

  private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

  private static final String MULTIPLY = "*";
  private static final String ADD = "+";
  private static final String SUBTRACT = "-";

  public static void main(String[] args) {
    String[] input = {"3", "+", "2", "*", "3", "-", "4"};
    System.out.println(calculate(input));

    System.out.println(13 / 5);
  }

  public static Integer calculate(String[] input) {
    Deque<String> stack = new ArrayDeque<>();

    for (String token : input) {
      processToken(stack, token);
    }

    return computeFinalResult(stack);
  }

  private static void processToken(Deque<String> stack, String token) {
    if (OPERATORS.contains(token)) {
      stack.addLast(token);
    } else {
      combineIfNecessary(stack, token);
    }
  }

  private static void combineIfNecessary(Deque<String> stack, String number) {
    if (MULTIPLY.equals(stack.peekLast())) {
      stack.removeLast(); // Remove operator
      String previousNumber = stack.removeLast();
      int result = Integer.parseInt(previousNumber) * Integer.parseInt(number);
      stack.addLast(String.valueOf(result));
    } else {
      stack.addLast(number);
    }
  }

  private static Integer computeFinalResult(Deque<String> stack) {
    int result = Integer.parseInt(stack.removeFirst());

    while (!stack.isEmpty()) {
      String operator = stack.removeFirst();
      int nextNumber = Integer.parseInt(stack.removeFirst());

      switch (operator) {
        case ADD -> result += nextNumber;
        case SUBTRACT -> result -= nextNumber;
        default -> throw new IllegalStateException("Unexpected operator: " + operator);
      }
    }

    return result;
  }
}