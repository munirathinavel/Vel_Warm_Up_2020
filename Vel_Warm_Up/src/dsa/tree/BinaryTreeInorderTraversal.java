package dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

public class BinaryTreeInorderTraversal {
  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    node1.left = node2;
    node1.right = node3;

    // inOrderTraversalRecursive(node1);
    inOrderTraversalIterative(node1);
  }

  private static void inOrderTraversalRecursive(TreeNode node1) {
    List<Integer> res = new ArrayList<>();
    inOrderTraversal(node1, res);

    printResult(res);
  }

  private static void printResult(List<Integer> res) {
    System.out.println();
    res.forEach(val -> {
      System.out.print(" " + val);
    });
  }

  private static void inOrderTraversal(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inOrderTraversal(root.left, res);
    res.add(root.val);
    inOrderTraversal(root.right, res);
  }

  private static void inOrderTraversalIterative(TreeNode root) {
    Stack<TreeNode> s = new Stack<>();
    List<Integer> res = new ArrayList<>();
    TreeNode current = root;
    while (current != null || !s.isEmpty()) {
      while (current != null) {
        s.add(current);
        current = current.left;
      }
      current = s.pop();
      res.add(current.val);
      current = current.right;
    }
    printResult(res);
  }

}
