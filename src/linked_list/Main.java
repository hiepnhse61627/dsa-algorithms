package linked_list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {

    Deque<String> deque = new LinkedList<>();

    deque.addLast("A");
    deque.addLast("B");

//    deque.stream().forEach(System.out::println);

//    Deque<String> stack = new ArrayDeque<>();
//    stack.addLast("A");
//    stack.addLast("B");
//
//    stack.forEach(System.out::println);
//
//    Queue<String> queue = new ArrayDeque<>();
//    queue.add("a");
//    queue.add("b");
//    queue.remove();
//
//    queue.forEach(System.out::println);

    Deque<String> stack2 = new ArrayDeque<>(3);
    stack2.addLast("A");
    stack2.addLast("B");
    stack2.addLast("C");
    stack2.addLast("D");
    stack2.forEach(System.out::println);

  }


}
