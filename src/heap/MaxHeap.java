package heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {

  private final List<Integer> heap;

  public MaxHeap() {
    this.heap = new ArrayList<>();
  }

  public List<Integer> getHeap() {
    return new ArrayList<>(heap);
  }

  public void insert(int value) {
    heap.add(value);

    int current = heap.size() - 1;
    while (current > 0 && heap.get(current) > heap.get(parent(current))) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public Integer remove() {
    if (heap.isEmpty()) {
      return null;
    }
    if (heap.size() == 1) {
      return heap.removeFirst();
    }

    int maxValue = heap.getFirst();
    heap.set(0, heap.removeLast());
    sinkDown(0);

    return maxValue;
  }

  private void sinkDown(int index) {
    int maxIndex = index;
    while (true) {
      int leftIndex = leftChild(index);
      int rightIndex = rightChild(index);

      if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
        maxIndex = leftIndex;
      }
      if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
        maxIndex = rightIndex;
      }
      if (maxIndex != index) {
        swap(index, maxIndex);
        index = maxIndex;
      } else {
        return;
      }
    }
  }

  private int leftChild(int index) {
    return index * 2 + 1;
  }

  private int rightChild(int index) {
    return index * 2 + 2;
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private void swap(int index1, int index2) {
    int temp = heap.get(index1);
    heap.set(index1, heap.get(index2));
    heap.set(index2, temp);
  }
}
