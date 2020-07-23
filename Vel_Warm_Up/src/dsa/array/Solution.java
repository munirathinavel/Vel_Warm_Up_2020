package dsa.array;

class Solution {
  public static void main(String[] args) {
  //  System.out.println(longestPalindrome("babad"));
    //System.out.println(longestPalindrome("cbbd"));
    System.out.println(longestPalindrome("abacdfgdcaba"));
  }

  public static String longestPalindrome(String s) {
    String s2 = new StringBuilder(s).reverse().toString();
    StringBuilder sb = new StringBuilder();
    int maxLength = 0;
    String maxString = "";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == s2.charAt(i)) {
        sb.append(s.charAt(i));
      } else {
        if (isPalindrome(sb.toString()) && maxLength < sb.length()) {
          maxString = sb.toString();
          maxLength = sb.length();
        }
        sb.setLength(0);
        //sb.append(s.charAt(i));
      }
    }
    return maxString;
  }

  static boolean isPalindrome(String s) {
    int lo = 0;
    int hi = s.length() - 1;
    if (s.length() < 1 && lo != hi) {
      return false;
    }
    while (lo < hi) {
      if (s.charAt(lo) != s.charAt(hi)) {
        return false;
      }
      lo++;
      hi--;
    }
    return true;
  }
}