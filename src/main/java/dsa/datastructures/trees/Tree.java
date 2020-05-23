package dsa.datastructures.trees;

import java.util.LinkedList;

public class Tree {

    /**
     * iterative level order (BFS) traversal of a tree
     * 
     * <p>
     * O(n) Time and O(log n) Space
     * 
     * @param root
     * @return
     */
    public static String levelOrder(TreeNode root) {
        String s = "";
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return s;
        }
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                if (!q.isEmpty()) {
                    q.add(null);

                }
            } else {
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                s = s + Integer.toString(curr.data) + ",";
            }
        }
        return s.substring(0, s.length() - 1);
    }

    private class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }
}