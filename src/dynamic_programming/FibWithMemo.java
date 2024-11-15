package dynamic_programming;

public class FibWithMemo {

  private static final Integer[] memo = new Integer[100];
  private static int counter = 0;


  public static int fib(int n) {
    counter++;

    if (memo[n] != null) {
      return memo[n];
    }

    if (n == 0 || n == 1) {
      return n;
    }

    memo[n] = fib(n - 1) + fib(n - 2);
    return memo[n];
  }

  public static void main(String[] args) {
    int n = 40;

    System.out.println("Fib(" + n + ") = " + fib(n));
    System.out.println("Counter = " + counter);
  }
}
