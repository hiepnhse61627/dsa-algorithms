package linked_list;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  static class Node {

    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  public LinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void append(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }

    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }

    Node pre = head;
    Node temp = head;
    while (temp.next != null) {
      pre = temp;
      temp = temp.next;
    }

    tail = pre;
    tail.next = null;
    length--;

    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }

    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }

    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;

    if (length == 0) {
      tail = null;
    }

    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }

    return temp;
  }

  public boolean set(int index, int value) {
    Node node = get(index);

    if (node != null) {
      node.value = value;
      return true;
    }

    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }

    if (index == 0) {
      prepend(value);
      return true;
    }

    if (index == length) {
      append(value);
      return true;
    }

    Node newNode = new Node(value);
    Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    if (index == 0) {
      return removeFirst();
    }

    if (index == length - 1) {
      return removeLast();
    }

    Node nodeBeforeIndex = get(index - 1);
    Node temp = nodeBeforeIndex.next;
    nodeBeforeIndex.next = temp.next;
    temp.next = null;
    length--;

    return temp;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }

  public void getHead() {
    System.out.println("Head: " + (Objects.isNull(head) ? "null" : head.value));
  }

  public void getTail() {
    System.out.println("Tail: " + (Objects.isNull(tail) ? "null" : tail.value));
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  /**
   * Leetcode questions
   */
  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;

    Node before = null;
    Node after;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public Node findMiddleNode() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public boolean hasLoop() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public Node findKthFromEnd(int k) {
    Node slow = head;
    Node fast = head;

    for (int i = 0; i < k; i++) {
      if (fast == null) {
        return null;
      }
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  public void partitionList(int x) {
    if (head == null) {
      return;
    }

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);
    Node prev1 = dummy1;
    Node prev2 = dummy2;
    Node current = head;

    while (current != null) {
      int value = current.value;
      if (value < x) {
        prev1.next = current;
        prev1 = current;
      } else {
        prev2.next = current;
        prev2 = current;
      }
      current = current.next;
    }

    prev2.next = null;
    prev1.next = dummy2.next;
    head = dummy1.next;
  }

  public void removeDuplicatesVersion1() {
    Set<Integer> values = new HashSet<>();
    Node prev = null;
    Node current = head;

    while (current != null) {
      int value = current.value;
      if (values.contains(value)) {
        prev.next = current.next;
        length--;
      } else {
        values.add(value);
        prev = current;
      }
      current = current.next;
    }
  }

  public void removeDuplicatesVersion2() {
    Node current = head;

    while (current != null) {
      Node runner = current;
      while (runner.next != null) {
        if (runner.next.value == current.value) {
          runner.next = runner.next.next;
          length--;
        } else {
          runner = runner.next;
        }
      }
      current = current.next;
    }
  }

  public int binaryToDecimal() {
    int num = 0;
    Node current = head;

    while (current != null) {
      num = num * 2 + current.value;
      current = current.next;
    }

    return num;
  }

  public void reverseBetween(int startIndex, int endIndex) {
    if (head == null) {
      return;
    }

    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;

    for (int i = 0; i < startIndex; i++) {
      previousNode = previousNode.next;
    }

    Node currentNode = previousNode.next;

    for (int i = 0; i < endIndex - startIndex; i++) {
      Node nodeToMove = currentNode.next;
      currentNode.next = nodeToMove.next;
      nodeToMove.next = previousNode.next;
      previousNode.next = nodeToMove;
    }

    head = dummyNode.next;
  }

  public void bubbleSort() {
    if (length < 2) {
      return;
    }

    Node sortedUntil = null;

    while (sortedUntil != head.next) {
      Node current = head;

      while (current.next != sortedUntil) {
        Node nextNode = current.next;
        if (current.value > nextNode.value) {
          int temp = current.value;
          current.value = nextNode.value;
          nextNode.value = temp;
        }
        current = current.next;
      }

      sortedUntil = current;
    }
  }

  public void selectionSort() {
    if (length < 2) {
      return;
    }

    Node current = head;

    while (current.next != null) {
      Node smallest = current;
      Node innerCurrent = current.next;

      while (innerCurrent != null) {
        if (innerCurrent.value < smallest.value) {
          smallest = innerCurrent;
        }
        innerCurrent = innerCurrent.next;
      }

      if (smallest != current) {
        int temp = current.value;
        current.value = smallest.value;
        smallest.value = temp;
      }

      current = current.next;
    }

    tail = current;
  }

  public void insertionSort() {
    if (length < 2) {
      return;
    }

    Node sortedListHead = head;
    Node unsortedListHead = head.next;
    sortedListHead.next = null;

    while (unsortedListHead != null) {
      Node current = unsortedListHead;
      unsortedListHead = unsortedListHead.next;

      if (current.value < sortedListHead.value) {
        current.next = sortedListHead;
        sortedListHead = current;
      } else {
        Node searchPointer = sortedListHead;
        while (searchPointer.next != null && current.value > searchPointer.next.value) {
          searchPointer = searchPointer.next;
        }
        current.next = searchPointer.next;
        searchPointer.next = current;
      }
    }

    head = sortedListHead;
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    tail = temp;
  }

  public void merge(LinkedList otherList) {
    Node otherHead = otherList.head;
    Node dummy = new Node(0);
    Node current = dummy;

    while (head != null && otherHead != null) {
      if (head.value < otherHead.value) {
        current.next = head;
        head = head.next;
      } else {
        current.next = otherHead;
        otherHead = otherHead.next;
      }
      current = current.next;
    }

    if (head != null) {
      current.next = head;
    } else {
      current.next = otherHead;
      tail = otherList.tail;
    }

    head = dummy.next;
    length += otherList.length;
  }
}
