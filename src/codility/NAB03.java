package codility;

public class NAB03 {

  public static void main(String[] args) {
    // Test cases
    System.out.println(solution(new int[]{4, 1, 2, 3})); // Expected: 6
    System.out.println(solution(new int[]{1, 2, 3, 3, 2, 1, 5})); // Expected: 7
    System.out.println(
        solution(new int[]{1000000000, 1, 2, 2, 1000000000, 1, 1000000000})); // Expected: 999999998
  }

  public static int solution(int[] A) {
    final long MOD = 1000000000L;
    int n = A.length;

    long profit = 0;

    // Greedy approach: Get every profitable move
    // buy low, sell high
    for (int i = 1; i < n; i++) {
      if (A[i] > A[i - 1]) {
        profit = (profit + A[i] - A[i - 1]) % MOD;
      }
    }

    // Add the price of selling the initial asset on day 0
    profit = (profit + A[0]) % MOD;

    return (int) profit;
  }


}
