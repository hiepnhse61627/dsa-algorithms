package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) {
    // Test case 1
//    int[] nums1 = {7, 10, 4, 3, 20, 15};
//    int k1 = 3;
//    System.out.println("Test case 1:");
//    System.out.println("Expected output: 7");
//    System.out.println("Actual output: " + findKthSmallest(nums1, k1));
//    System.out.println();
//
//    // Test case 2
//    int[] nums2 = {2, 1, 3, 5, 6, 4};
//    int k2 = 2;
//    System.out.println("Test case 2:");
//    System.out.println("Expected output: 2");
//    System.out.println("Actual output: " + findKthSmallest(nums2, k2));
//    System.out.println();
//
//    // Test case 3
//    int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
//    int k3 = 5;
//    System.out.println("Test case 3:");
//    System.out.println("Expected output: 7");
//    System.out.println("Actual output: " + findKthSmallest(nums3, k3));
//    System.out.println();

    // Test case 1
    int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
    System.out.println("Test case 1:");
    System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
    System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
    System.out.println("Actual output: " + streamMax(nums1));
    System.out.println();

    // Test case 2
    int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
    System.out.println("Test case 2:");
    System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
    System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
    System.out.println("Actual output: " + streamMax(nums2));
    System.out.println();

    // Test case 3
    int[] nums3 = {3, 3, 3, 3, 3};
    System.out.println("Test case 3:");
    System.out.println("Input: [3, 3, 3, 3, 3]");
    System.out.println("Expected output: [3, 3, 3, 3, 3]");
    System.out.println("Actual output: " + streamMax(nums3));
    System.out.println();
  }

  public static int findKthSmallest(int[] arr, int k) {
    MaxHeap maxHeap = new MaxHeap();

    for (int num : arr) {
      maxHeap.insert(num);

      if (maxHeap.getHeap().size() > k) {
        maxHeap.remove();
      }
    }

    return maxHeap.remove();
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.offer(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    if (minHeap.isEmpty()) {
      return -1;
    }

    return minHeap.poll();
  }

  public static List<Integer> streamMax(int[] nums) {
    List<Integer> list = new ArrayList<>();
    MaxHeap maxHeap = new MaxHeap();

    for (int num : nums) {
      maxHeap.insert(num);
      list.add(maxHeap.getHeap().getFirst());
    }

    return list;
  }
}
