package com.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumSumKDivisions {

  public static void main(String[] args) {
    System.out
        .println("Sum = " + minimumSumAfterKOperations(Arrays.asList(2, 3, 6, 8, 10, 12, 14, 16, 18, 20, 50), 10));
    System.out.println("Sum = " + minimumSumAfterKOperations(Arrays.asList(20, 10, 5), 3));
    System.out.println("Sum = " + minimumSumAfterKOperations(Arrays.asList(1, 2, 3, 4, 5), 2));
  }

  private static int minimumSumAfterKOperations(List<Integer> data, int k) {
    if (data.size() <= 1) {
      return 0;
    }
    int index = 0;
    int max = Integer.MAX_VALUE;
    while (k > 0) {
      int val = data.get(index);
      if (val <= max) {
        data.sort(Comparator.reverseOrder());
        index = 0;
        max = data.get(index) / 2;
        continue;
      }
      k--;
      int roundUp = val & 1;
      val = val / 2 + roundUp;
      data.set(index, val);
      if (index < data.size() - 1) {
        index++;
      }
    }
    return data.stream().mapToInt(a -> a).sum();
  }

}
