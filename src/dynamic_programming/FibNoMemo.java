package dynamic_programming;

public class FibNoMemo {

  private static int counter = 0;

  public static int fib(int n) {
    counter++;

    if (n == 0 || n == 1) {
      return n;
    }

    return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    int n = 7;

    System.out.println("Fib(" + n + ") = " + fib(40));
    System.out.println("Counter = " + counter);
  }
}
