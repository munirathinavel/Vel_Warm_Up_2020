package com.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
  public static void main(String[] args) {
    int[] candidates = { 2, 3, 5 };
    List<List<Integer>> res = combinationSum(candidates, 8);
    printResult(res);

    int[] candidates2 = { 2, 3, 6, 7 };
    res = combinationSum(candidates2, 7);
    printResult(res);
  }

  private static void printResult(List<List<Integer>> res) {
    for (List<Integer> list : res) {
      System.out.println(list);
    }
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    List<Integer> list = new ArrayList<>();

    for (int val : candidates) {
      int quotient = target / val;
      int reminder = target % val;

      int diff = target - (val * quotient);
      if (reminder == 0) {
        addToList(list, val, quotient);
      } else if (set.contains(diff)) {
        list.add(diff);
        addToList(list, val, quotient);
      }
      set.add(val);
      if (!list.isEmpty()) {
        res.add(list);
        list = new ArrayList<>();
      }
    }

    return res;
  }

  private static void addToList(List<Integer> list, int val, int quotient) {
    for (int i = 0; i < quotient; i++) {
      list.add(val);
    }
  }
}