package dsa.tree;

import java.util.Deque;
import java.util.LinkedList;

public class DEQueue {
  public static void main(String[] args) {
    
    Deque<String> dequeue = new LinkedList<>();
    dequeue.add("1 tail");
    dequeue.addFirst("2 head");
    dequeue.addLast("3 tail");
    dequeue.push("4 head");
    dequeue.offer("5 tail");
    dequeue.offerFirst("6 head");
    dequeue.offerLast("7 tail");
    dequeue.add("8 head");
    
    System.out.println(dequeue + " \n");
   /* while(!dequeue.isEmpty()) {
      System.out.println(dequeue.remove());
    }*/
    
  }
}
