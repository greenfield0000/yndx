package com.example.yandex.demo.runners;

/**
 * @author Ivanov Roman
 */
public class SymmetricTree {

    public static class TreeNode {
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

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (
            // 4 root val
                left != null && right != null && left.val == right.val
                        // равны значения
                        && ((left.left != null && left.right != null && right.left != null && right.right != null && left.left.val == right.right.val && left.right.val == right.left.val)
                        // или они симметрично раны нулам
                        || (left.left == null && right.right == null) || (left.right == null && right.left == null))
        ) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;


        left.right = new TreeNode(3);
        right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

}
