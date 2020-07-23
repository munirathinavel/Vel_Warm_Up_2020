package dsa.tree;

import java.util.Arrays;

public class ZeroMatrix {
  public static void main(String[] args) {
    int[][] m = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
    setZeroes(m); // [[-2147483648],[2],[3]]
    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[i].length; j++) {
        System.out.print(" " + m[i][j]);
      }
      System.out.println();
    }
  }

  public static void setZeroes(int[][] matrix) {
    int n1 = matrix.length;
    int n2 = matrix[0].length;

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        if (matrix[i][j] == 0) {
          for (int i1 = 0; i1 < n1; i1++) {
            if (matrix[i1][j] != 0) {
              matrix[i1][j] = Integer.MIN_VALUE;
            }
          }
          for (int j1 = 0; j1 < n2; j1++) {
            if (matrix[i][j1] != 0) {
              matrix[i][j1] = Integer.MIN_VALUE;
            }
          }
        }

        String s = new String();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String s2 = Arrays.toString(c);
      }
    }

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        if (matrix[i][j] == Integer.MIN_VALUE) {
          matrix[i][j] = 0;
        }
      }
    }
  }

}
