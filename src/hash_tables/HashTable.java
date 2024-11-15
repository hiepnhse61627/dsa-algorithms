package hash_tables;

import java.util.ArrayList;

public class HashTable {

  private final int size = 7;
  private final Node[] dataMap;

  static class Node {

    private final String key;
    private final int value;
    private Node next;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  public HashTable() {
    dataMap = new Node[size];
  }

  public void printTable() {
    for (int i = 0; i < dataMap.length; i++) {
      System.out.println(i + ":");
      Node temp = dataMap[i];
      while (temp != null) {
        System.out.println("   {" + temp.key + "= " + temp.value + "}");
        temp = temp.next;
      }
    }
  }

  public void set(String key, int value) {
    int index = hash(key);
    Node newNode = new Node(key, value);

    if (dataMap[index] == null) {
      dataMap[index] = newNode;
    } else {
      Node temp = dataMap[index];
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public int get(String key) {
    int index = hash(key);
    Node temp = dataMap[index];

    while (temp != null) {
      if (temp.key.equals(key)) {
        return temp.value;
      }
      temp = temp.next;
    }

    return 0;
  }

  public ArrayList<String> keys() {
    ArrayList<String> keys = new ArrayList<>();
    for (Node node : dataMap) {
      Node temp = node;
      while (temp != null) {
        keys.add(temp.key);
        temp = temp.next;
      }
    }
    return keys;
  }

  private int hash(String key) {
    int hash = 0;
    char[] keyChars = key.toCharArray();
    for (int asciiValue : keyChars) {
      hash = (hash + asciiValue * 23) % dataMap.length;
    }
    return hash;
  }
}
