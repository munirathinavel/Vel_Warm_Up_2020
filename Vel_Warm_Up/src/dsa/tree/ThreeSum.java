package dsa.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
  public static void main(String[] args) {
    List<List<Integer>> res = threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
    System.out.println(res);
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
      if (i == 0 || nums[i] != nums[i - 1])
        find2Sum(i, nums, res);
    }
    return res;
  }

  private static void find2Sum(int i, int[] nums, List<List<Integer>> res) {
    int lo = i + 1;
    int hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[i] + nums[lo] + nums[hi];
      if (sum < 0 || (lo > i + 1 && nums[lo] == nums[lo - 1])) {
        lo++;
      } else if (sum > 0 || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
        hi--;
      } else {
        res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
      }
    }
  }

}