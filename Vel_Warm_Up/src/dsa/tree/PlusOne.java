package dsa.tree;

public class PlusOne {
  public static void main(String[] args) {
    int[] a = { 1,2,9,9,9,9 };
    //plusOne(a);
    plusOne_2(a);
  }

  public static int[] plusOne(int[] digits) {
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      carry = (digits[i] + carry) / 10;
      digits[i] = (digits[i] + carry) % 10;
    }
    if (carry > 0) {
      int r[] = new int[digits.length + 1];
      r[0] = 1;
      for (int i = digits.length - 1; i >= 1; i--) {
        r[i] = digits[i];
      }
      digits = r;
    }
    return digits;
  }

  public static int[] plusOne_2(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      int num = digits[i] + 1;
      if (num < 10) {
        digits[i] = num;
        return digits;
      }
      digits[i] = 0;
    }
    int newN[] = new int[digits.length + 1];
    newN[0] = 1;
    return newN;
  }

}
