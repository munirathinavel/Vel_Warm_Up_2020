package dsa.tree;

import java.util.HashSet;

public class RotateArrayKTimes {

  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, 5, 6, 7 };
    /*
     * rotateArray_Copy(a, 3); for (int n : a) { System.out.print(n + " "); }
     */
    // rotateArrayInMemory(a, 3);
    // rotateKTimesByEachIteration(a, 3);
    a = rotateKTimesByCopyArray(a, 3);
    for (int n : a) {
      System.out.print(n + " ");
    }
  }

  private static int[] rotateKTimesByCopyArray(int[] a, int k) {
    int n = a.length;
    int b[] = new int[n];
    for (int i = 0; i < n; i++) {
      b[(i + k) % n] = a[i];
    }
    for (int i : b) {
      System.out.print(i + " ");
    }
    System.out.println();
    return b;
  }

  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> t = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (t.contains(nums[i])) {
        return true;
      } else {
        t.add(nums[i]);
      }
    }
    return false;
  }

  /**
   * 
   * TOO SLOW. TIME LIMIT EXCEEDED
   * 
   * @param a
   * @param k
   */
  private static void rotateKTimesByEachIteration(int[] a, int k) {
    int n = a.length;
    for (int i = 0; i < k; i++) {
      int next;
      int current = a[0];
      for (int j = 1; j <= n; j++) {
        next = a[j % n];
        a[j % n] = current;
        current = next;
      }
    }
  }

  private static void rotateArrayInMemory(int[] a, int k) {
    int current = 0;
    int target = current + k;
    int prev;
    do {
      prev = a[target];
      a[target] = a[current++];
      target = (current + k) % a.length;
    } while (current != 0);
  }
  // 1,2,3,4,5,6,7 k=2

  // 6,7,1,2,3,4,5

  private static void rotateArray_Copy(int[] a, int k) {
    int len = a.length;
    int b[] = new int[len];
    for (int i = 0; i < len; i++) {
      b[i] = a[(i + k) % len];
    }
    a = b;
    for (int n : b) {
      System.out.print(n + " ");
    }
    System.out.println();
    System.arraycopy(b, 0, a, 0, len);
  }

}
