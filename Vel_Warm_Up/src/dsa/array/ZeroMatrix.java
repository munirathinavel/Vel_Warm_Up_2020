package dsa.array;

import java.util.HashSet;

public class ZeroMatrix {
  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 4, 5, 6 };
    System.out.println("cool");
    System.out.println("result:" + findPairWithSum(a, 5));
  }

  private static boolean findPairWithSum(int[] a, int sum) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < a.length; i++) {
      int diff = sum - a[i];
      if (set.contains(diff)) {
        return true;
      }
    }
    return false;
  }
}
