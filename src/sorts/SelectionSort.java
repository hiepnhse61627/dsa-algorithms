package sorts;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{4, 2, 6, 5, 1, 3};

    selectionSort(arr);

    System.out.println(Arrays.toString(arr));

  }

  private static void selectionSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
      }
    }
  }
}
