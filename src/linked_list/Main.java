package linked_list;

public class Main {

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList(4);
    linkedList.append(2);
    linkedList.append(1);
    linkedList.append(3);

    linkedList.insertionSort();

    linkedList.printList();
  }
}
