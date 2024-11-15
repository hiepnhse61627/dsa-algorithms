package trees;

public class Main {

  public static void main(String[] args) {

    BinarySearchTreeLearning myBST = new BinarySearchTreeLearning();

    myBST.rInsert(47);
    myBST.rInsert(21);
    myBST.rInsert(76);
    myBST.rInsert(18);
    myBST.rInsert(27);
    myBST.rInsert(52);
    myBST.rInsert(82);

    System.out.println("Breath First Search: " + myBST.BFS());
    System.out.println("Depth First Search (Pre Order): " + myBST.DFSPreOrder());
    System.out.println("Depth First Search (Post Order): " + myBST.DFSPostOrder());
    System.out.println("Depth First Search (In Order): " + myBST.DFSInOrder());
//
//    myBST.rInsert(2);
//    myBST.rInsert(1);
//    myBST.rInsert(3);
//
//    System.out.println("Root: " + myBST.root.value);
//    System.out.println("Root -> Left: " + myBST.root.left.value);
//    System.out.println("Root -> Right: " + myBST.root.right.value);
//
//    myBST.deleteNode(2);
//
//
//    System.out.println("Root: " + myBST.root.value);
//    System.out.println("Root -> Left: " + myBST.root.left.value);
//    System.out.println("Root -> Right: " + myBST.root.right);

//    BinarySearchTree bst = new BinarySearchTree();
//
//    int[] nums = {1, 2, 3, 4, 5};
//    bst.sortedArrayToBST(nums);
//
//    System.out.println(bst.inorderTraversal());
  }
}
