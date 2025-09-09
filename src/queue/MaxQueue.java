package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {

  private final Deque<Integer> entryQueue; // queue chua data ban dau

  private final Deque<Integer> candidateQueue; // queue chua cac phan tu co the la max

  MaxQueue() {
    entryQueue = new ArrayDeque<>();
    candidateQueue = new ArrayDeque<>();
  }

  void enqueue(int x) {
    entryQueue.addLast(x);

    while (!candidateQueue.isEmpty() && candidateQueue.getLast() < x) {
      candidateQueue.removeLast();
    }

    candidateQueue.addLast(x);
  }

  public int dequeue() {
    int removedElement = entryQueue.removeFirst();

    if (!candidateQueue.isEmpty() && removedElement == candidateQueue.getFirst()) {
      candidateQueue.removeFirst();
    }

    return removedElement;
  }

  public int getMax() {
    return candidateQueue.getFirst();
  }
}
