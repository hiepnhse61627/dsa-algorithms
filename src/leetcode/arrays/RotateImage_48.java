package leetcode.arrays;

import java.util.Arrays;

/**
 * <p>
 * Problem Link:
 * <a href="https://leetcode.com/problems/rotate-image/">48. Rotate Image</a>
 */
public class RotateImage_48 {

  public static void main(String[] args) {
    rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
  }

  public static void rotate(int[][] matrix) {
    int matrixLength = matrix.length;

    // tranpose
    for (int row = 0; row < matrixLength; row++) {
      for (int col = row + 1; col < matrixLength; col++) {
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
      }
    }

    System.out.println(Arrays.deepToString(matrix));
  }
}
