package codility;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NAB01 {

  public static void main(String[] args) {
    // Test cases
    System.out.println(solution(5, 8));
    System.out.println(solution(4, 10));
    System.out.println(solution(1, 2));
    System.out.println(solution(10, 5));
  }

  public static int solution(int N, int K) {
    // Maximum capacity is the sum of 1 + 2 + ... + N = N * (N + 1) / 2
    long maxCapacity = (long) N * (N + 1) / 2;

    // If K is greater than the max capacity, return -1 as it is not possible
    if (K > maxCapacity) {
      return -1;
    }

    // If K equals the max capacity, use all glasses
    if (K == maxCapacity) {
      return N;
    }

    // Greedy approach: start from the largest glass and work backwards
    int glassesUsed = 0;
    int remainingWater = K;

    for (int glassSize = N; glassSize >= 1; glassSize--) {
      if (remainingWater >= glassSize) {
        remainingWater -= glassSize;
        glassesUsed++;
      }

      if (remainingWater == 0) {
        break;
      }
    }

    return remainingWater == 0 ? glassesUsed : -1;
  }



}