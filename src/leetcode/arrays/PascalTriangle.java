package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates Pascal's Triangle up to a specified number of rows.
 * <p>
 * Problem Link: <a href="https://leetcode.com/problems/pascals-triangle/">118. Pascal's
 * Triangle</a>
 * </p>
 *
 * <p>Example Triangle:
 * <pre>
 *      1  <-- i = 0
 *     1 1
 *    1 2 1  <-- i = 2, j = 1 -> middle element = previousRow[0] + previousRow[1] = 2
 *   1 3 3 1  <-- i = 3, j = 1 -> previousRow[0] + previousRow[1] = 3, j = 2 -> previousRow[1] + previousRow[2] = 3
 *  1 4 6 4 1
 * </pre>
 * </p>
 *
 * <h3>Approach:</h3>
 * <ul>
 *   <li>Add the first row containing a single element (1).</li>
 *   <li>Iterate from <code>i = 1</code> to <code>numRows - 1</code>:
 *     <ul>
 *       <li>Create a new row for the triangle.</li>
 *       <li>Add the first element (1) to the new row.</li>
 *       <li>For each row <code>i</code>, iterate from <code>j = 1</code> to <code>i - 1</code> to calculate the middle elements.
 *         Each middle element is the sum of two adjacent elements from the previous row.</li>
 *       <li>Add the last element (1) to the new row.</li>
 *       <li>Add the new row to the result list.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <h3>Example Calculation:</h3>
 * <ul>
 *   <li><code>i = 2</code>:
 *     <ul>
 *       <li><code>j = 1</code>: previousRow[0] + previousRow[1] = 1 + 1 = 2 → Row: [1, 2, 1]</li>
 *     </ul>
 *   </li>
 *   <li><code>i = 3</code>:
 *     <ul>
 *       <li><code>j = 1</code>: previousRow[0] + previousRow[1] = 1 + 2 = 3 → Row starts as [1, 3]</li>
 *       <li><code>j = 2</code>: previousRow[1] + previousRow[2] = 2 + 1 = 3 → Completed row: [1, 3, 3, 1]</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <h3>Complexity Analysis:</h3>
 * <ul>
 *   <li>Time Complexity: <code>O(numRows^2)</code>
 *     <ul>
 *       <li>The outer loop runs <code>numRows</code> times.</li>
 *       <li>The inner loop runs up to <code>i - 1</code> times for each row.</li>
 *       <li>Total operations: 1 + 2 + 3 + ... + (numRows - 1) = O(numRows^2).</li>
 *     </ul>
 *   </li>
 *   <li>Space Complexity: <code>O(numRows^2)</code>
 *     <ul>
 *       <li>The result list stores all elements of the triangle, which grows quadratically with <code>numRows</code>.</li>
 *     </ul>
 *   </li>
 * </ul>
 */
public class PascalTriangle {

  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> resultList = new ArrayList<>();

    if (numRows == 0) {
      return resultList;
    }

    // add first row
    resultList.add(List.of(1));

    for (int i = 1; i < numRows; i++) {
      List<Integer> previousRow = resultList.get(i - 1);
      List<Integer> currentRow = new ArrayList<>();

      // add first element
      currentRow.add(1);

      // generate middle elements, calculate sum of adjacency pairs of previous row
      for (int j = 1; j < i; j++) {
        currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
      }

      // add last element
      currentRow.add(1);

      resultList.add(currentRow);
    }

    return resultList;
  }
}
