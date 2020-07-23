package com.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinStepsToSameHeight {
  public static void main(String[] args) {
    // System.out.println(minStepsToSameHeight(Arrays.asList(5, 2, 1)));
    System.out.println(minStepsToSameHeight(Arrays.asList(4, 5, 5, 4, 2)));
    System.out.println(minStepsToSameHeight(Arrays.asList(4, 5, 5, 4, 2, 8, 12)));

    // System.out.println(minStepsToSameHeight2(Arrays.asList(5, 2, 1)));
    System.out.println(minStepsToSameHeight2(Arrays.asList(4, 5, 5, 4, 2)));
    System.out.println(minStepsToSameHeight2(Arrays.asList(4, 5, 5, 4, 2, 8, 12)));
  }

  private static int minStepsToSameHeight2(List<Integer> data) {
    int steps = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int val : data) {
      map.put(val, map.getOrDefault(val, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> maxQueue = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
    maxQueue.addAll(map.entrySet());

    while (maxQueue.size() > 1) {
      Map.Entry<Integer, Integer> e1 = maxQueue.poll();
      Map.Entry<Integer, Integer> e2 = maxQueue.poll();
      steps = steps + e1.getValue();
      e2.setValue(e1.getValue() + e2.getValue());
      maxQueue.offer(e2);
    }
    return steps;
  }

  private static int minStepsToSameHeight(List<Integer> data) {
    if (data.size() <= 1) {
      return 0;
    }
    int steps = 0;
    int distinctNums = 0;
    data.sort(Comparator.naturalOrder());
    for (int i = 1; i < data.size(); i++) {
      if (data.get(i) == data.get(i - 1)) {
        steps += distinctNums;
      } else {
        distinctNums++;
        steps += distinctNums;
      }
    }
    return steps;
  }

}
