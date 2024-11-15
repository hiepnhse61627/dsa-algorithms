package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeLearning {

  Node root;

  class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
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

      if (newNode.value < temp.value) { // move left
        if (temp.left == null) { // slot is opened
          temp.left = newNode;
          return true;
        }
        temp = temp.left; // move to next node
      } else { // move right
        if (temp.right == null) { // slot is opened
          temp.right = newNode;
          return true;
        }
        temp = temp.right; // move to next node
      }
    }
  }

  public boolean contains(int value) {
    Node temp = root;

    while (temp != null) {
      if (value < temp.value) {
        temp = temp.left;
      } else if (value > temp.value) {
        temp = temp.right;
      } else {
        return true;
      }
    }

    return false;
  }

  public boolean rContains(int value) {
    return rContains(root, value);
  }

  private boolean rContains(Node currentNode, int value) {
    if (currentNode == null) {
      return false;
    }

    if (currentNode.value == value) {
      return true;
    }

    if (value < currentNode.value) {
      return rContains(currentNode.left, value);
    } else {
      return rContains(currentNode.right, value);
    }
  }

  public void rInsert(int value) {
    if (root == null) {
      root = new Node(value);
    }
    rInsert(root, value);
  }

  private Node rInsert(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    }

    if (value < currentNode.value) {
      currentNode.left = rInsert(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = rInsert(currentNode.right, value);
    }

    return currentNode;
  }

  public void deleteNode(int value) {
    deleteNode(root, value);
  }

  private Node deleteNode(Node currentNode, int value) {
    if (currentNode == null) {
      return null;
    }

    // traversing the tree to find if the value is in the tree or not
    if (value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
    } else {
      // found the value
      if (currentNode.left == null && currentNode.right == null) {
        // 1. Only leaf Node
        return null;
      } else if (currentNode.left == null) {
        // 2. Has Node on the right.
        currentNode = currentNode.right;
      } else if (currentNode.right == null) {
        // 3. Has Node on the left.
        currentNode = currentNode.left;
      } else {
        // 4. Has Node on each side.
        int subTreeMin = minValue(currentNode.right);
        currentNode.value = subTreeMin;
        currentNode.right = deleteNode(currentNode.right, subTreeMin);
      }
    }

    return currentNode;
  }

  public int minValue(Node currentNode) {
    while (currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }

  public List<Integer> BFS() {
    Node currentNode = root;
    Queue<Node> queue = new LinkedList<>();
    List<Integer> results = new ArrayList<>();
    queue.add(currentNode);

    while (!queue.isEmpty()) {
      currentNode = queue.remove();
      results.add(currentNode.value);

      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }

      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }
    }

    return results;
  }

  public List<Integer> DFSPreOrder() {
    List<Integer> results = new ArrayList<>();

//    traversePreOrder(root, results);
    class Traverse {

      public Traverse(Node currentNode) {
        results.add(currentNode.value);
        if (currentNode.left != null) {
          new Traverse(currentNode.left);
        }
        if (currentNode.right != null) {
          new Traverse(currentNode.right);
        }
      }
    }

    new Traverse(root);
    return results;
  }

  private void traversePreOrder(Node currentNode, List<Integer> results) {
    if (currentNode == null) {
      return;
    }

    results.add(currentNode.value);
    traversePreOrder(currentNode.left, results);
    traversePreOrder(currentNode.right, results);
  }

  public List<Integer> DFSPostOrder() {
    List<Integer> results = new ArrayList<>();

    traversePostOrder(root, results);
//    class Traverse {
//
//      public Traverse(Node currentNode) {
//        if (currentNode.left != null) {
//          new Traverse(currentNode.left);
//        }
//        if (currentNode.right != null) {
//          new Traverse(currentNode.right);
//        }
//        results.add(currentNode.value);
//      }
//    }
//
//    new Traverse(root);
    return results;
  }

  private void traversePostOrder(Node currentNode, List<Integer> results) {
    if (currentNode == null) {
      return;
    }

    traversePostOrder(currentNode.left, results);
    traversePostOrder(currentNode.right, results);
    results.add(currentNode.value);
  }

  public List<Integer> DFSInOrder() {
    List<Integer> results = new ArrayList<>();

    traverseInOrder(root, results);
//    class Traverse {
//
//      Traverse(Node currentNode) {
//        if (currentNode.left != null) {
//          new Traverse(currentNode.left);
//        }
//        results.add(currentNode.value);
//        if (currentNode.right != null) {
//          new Traverse(currentNode.right);
//        }
//      }
//    }
//
//    new Traverse(root);
    return results;
  }

  private void traverseInOrder(Node currentNode, List<Integer> results) {
    if (currentNode == null) {
      return;
    }

    traverseInOrder(currentNode.left, results);
    results.add(currentNode.value);
    traverseInOrder(currentNode.right, results);
  }
}
