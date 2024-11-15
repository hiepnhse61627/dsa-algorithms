package doubly_linked_list;

import java.util.Objects;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  static class Node {

    int value;
    Node next;
    Node prev;

    public Node(int value) {
      this.value = value;
    }
  }

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " ");
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

  public void append(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }

    Node temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      temp.prev = null;
    }
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
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }

    Node temp = head;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      temp.next = null;
    }
    length--;

    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    Node temp = head;
    if (index < length / 2) {
      for (int i = 0; i < index; i++) {
        temp = temp.next;
      }
    } else {
      temp = tail;
      for (int i = length - 1; i > index; i--) {
        temp = temp.prev;
      }
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
    Node before = get(index - 1);
    Node after = before.next;
    newNode.prev = before;
    newNode.next = after;
    before.next = newNode;
    after.prev = newNode;
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

//    Node nodeToRemove = get(index);
//    Node before = nodeToRemove.prev;
//    Node after = nodeToRemove.next;
//    before.next = after;
//    after.prev = before;
//    nodeToRemove.next = null;
//    nodeToRemove.prev = null;

    // 2nd way with only one variable
    Node nodeToRemove = get(index);
    nodeToRemove.next.prev = nodeToRemove.prev;
    nodeToRemove.prev.next = nodeToRemove.next;
    nodeToRemove.next = null;
    nodeToRemove.prev = null;

    length--;

    return nodeToRemove;
  }

  public void swapFirstLast() {
    if (length < 2) {
      return;
    }
    int temp = head.value;
    head.value = tail.value;
    tail.value = temp;
  }

  public void reverse() {
    if (length <= 1) {
      return;
    }

    Node current = head;
    Node temp;

    while (current != null) {
      temp = current.prev;
      current.prev = current.next;
      current.next = temp;
      current = current.prev;
    }

    // swap head and tail
    temp = head;
    head = tail;
    tail = temp;
  }

  public boolean isPalindrome() {
    if (length <= 1) {
      return true;
    }
//    StringBuilder s1 = new StringBuilder();
//    StringBuilder s2 = new StringBuilder();
//
//    Node temp1 = head;
//    Node temp2 = tail;
//    for (int i = 0; i < length; i++) {
//      s1.append(temp1.value);
//      temp1 = temp1.next;
//    }
//
//    for (int i = length - 1; i >= 0; i--) {
//      s2.append(temp2.value);
//      temp2 = temp2.prev;
//    }
//
//    return s1.toString().contentEquals(s2);
    Node forwardNode = head;
    Node backwardNode = tail;
    for (int i = 0; i < length / 2; i++) {
      if (forwardNode.value != backwardNode.value) {
        return false;
      }
      forwardNode = forwardNode.next;
      backwardNode = backwardNode.prev;
    }
    return true;
  }

  /**
   * 1 2 3 5 4
   * 2 1 5 3 4
   */
  public void swapPairs() {
    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;

    while (head != null && head.next != null) {
      Node firstNode = head;
      Node secondNode = head.next;

      // update pointers
      previousNode.next = secondNode;
      firstNode.next = secondNode.next;
      secondNode.next = firstNode;

      // update prev pointers
      secondNode.prev = previousNode;
      firstNode.prev = secondNode;
      if (firstNode.next != null) {
        firstNode.next.prev = firstNode;
      }

      // move pointers for next iteration
      head = firstNode.next;
      previousNode = firstNode;
    }

    head = dummyNode.next;
    if (head != null) {
      head.prev = null;
    }
  }
}
