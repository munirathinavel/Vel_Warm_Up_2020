package design;

/**
 * Definition for a binary tree node.
 */

public class Codec {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder res = new StringBuilder();
    serialize(res, root);
    return "";
  }

  private void serialize(StringBuilder res, TreeNode root) {
    if (root == null) {
      // res.append(null);
      return;
    }
    res.append(root.val);
    serialize(res, root.left);
    serialize(res, root.right);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data == null) {
      return null;
    }
    TreeNode root = new TreeNode(data.charAt(0));
    for (int i = 1; i < data.length(); i++) {
      // root.left;
    }
    return null;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));