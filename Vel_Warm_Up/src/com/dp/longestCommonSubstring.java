package com.dp;
/*package whatever //do not write package name here */

class longestCommonSubstring {
  public static void main(String[] args) {
    System.out.println(longestSubstring("bsbininm", "jmjkbkjkv"));
  }

  private static int longestSubstring(String s1, String s2) {
    int max = 0;
    int dp[][] = new int[s2.length()][s1.length()];
    for (int i = 0; i < s2.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        if (i == 0 || j == 0) {
          if (s1.charAt(j) == s2.charAt(i)) {
            dp[i][j] = 1;
          }
        } else {
          if (s1.charAt(j) == s2.charAt(i)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          }
        }
        if (max < dp[i][j]) {
          max = dp[i][j];
        }
      }
    }
    return max;
  }
}