package com.base.ds.nodes;

public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int data) {
        this.val = data;
        left = right = null;
    }

    TreeNode(TreeNode left, int data) {
        this.left = left;
        this.val = data;
        this.right = null;
    }

    TreeNode(int data, TreeNode right) {
        this.left = null;
        this.val = data;
        this.right = right;
    }

    TreeNode(TreeNode left, int data, TreeNode right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
