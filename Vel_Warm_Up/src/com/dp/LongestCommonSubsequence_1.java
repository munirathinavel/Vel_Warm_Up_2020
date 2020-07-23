package com.dp;

class LongestCommonSubsequence_1 {
  public static void main(String[] args) {
    // System.out.println(longestCommonSubsequence("bsb", "kb"));
    System.out.println(longestCommonSubsequence("abc", "abc"));
   // System.out.println(lcsDynamic("bsb".toCharArray(), "kb".toCharArray()));
  }

  public static int longestCommonSubsequence(String s1, String s2) { 
    int[][] dp = new int[s2.length()][s1.length()];
    int max = 0;
    for (int i = 0; i < s2.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        int match = s1.charAt(j) == s2.charAt(i) ? 1 : 0;
        if (i == 0 && j == 0) {
          dp[i][j] = match;
        } else if (i == 0 && j > 0) {
          dp[i][j] = Math.max(dp[i][j - 1], match);
        } else if (i > 0 && j == 0) {
          dp[i][j] = Math.max(dp[i - 1][j], match);
        } else {
          if (match == 0) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          } else {
            dp[i][j] = dp[i - 1][j - 1] + match;
          }
        }

        if (max < dp[i][j]) {
          max = dp[i][j];
        }
      }
    }
    return max;
  }

  public static int lcsDynamic(char str1[], char str2[]) {

    int temp[][] = new int[str1.length + 1][str2.length + 1];
    int max = 0;
    for (int i = 1; i < temp.length; i++) {
      for (int j = 1; j < temp[i].length; j++) {
        if (str1[i - 1] == str2[j - 1]) {
          temp[i][j] = temp[i - 1][j - 1] + 1;
        } else {
          temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
        }
        if (temp[i][j] > max) {
          max = temp[i][j];
        }
      }
    }
    return max;
  }
}