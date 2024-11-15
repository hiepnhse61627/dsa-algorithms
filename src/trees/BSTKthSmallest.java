package trees;

import java.util.Stack;

public class BSTKthSmallest {

  private Node root;

  class Node {

    public int value;
    public Node left;
    public Node right;

    Node(int value) {
      this.value = value;
    }
  }

  public boolean insert(int value) {
    Node newNode = new Node(value);
    if (root == null) {
      root = newNode;
      return true;
    }
    Node temp = root;
    while (true) {
      if (newNode.value == temp.value) {
        return false;
      }
      if (newNode.value < temp.value) {
        if (temp.left == null) {
          temp.left = newNode;
          return true;
        }
        temp = temp.left;
      } else {
        if (temp.right == null) {
          temp.right = newNode;
          return true;
        }
        temp = temp.right;
      }
    }
  }

  public Integer kthSmallest(int k) {
    if (root == null) {
      return null;
    }

    Stack<Node> stack = new Stack<>();
    Node currentNode = root;
    int count = 0;

    while (currentNode != null || !stack.isEmpty()) {
      while (currentNode != null) {
        stack.push(currentNode);
        currentNode = currentNode.left;
      }

      currentNode = stack.pop();
      count++;

      if (count == k) {
        return currentNode.value;
      }

      currentNode = currentNode.right;
    }

    return null;
  }
}
