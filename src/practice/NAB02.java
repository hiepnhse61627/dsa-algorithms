package practice;

public class NAB02 {

  public static void main(String[] args) {
    System.out.println(solution(new int[]{1, 1, 4, 4}, 4, 2));
    System.out.println(solution(new int[]{1, 1, 2, 4}, 4, 1));
    System.out.println(solution(new int[]{4, 2, 5}, 5, 2));
  }

  public static boolean solution(int[] values, int K, int L) {
    int[] count = new int[K + 1];
    for (int value : values) {
      if (value > K || ++count[value] > L) return false;
    }
    return true;
  }
}
