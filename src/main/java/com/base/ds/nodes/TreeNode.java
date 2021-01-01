package com.base.ds.nodes;

public class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }

    TreeNode(TreeNode left, int data) {
        this.left = left;
        this.data = data;
        this.right = null;
    }

    TreeNode(int data, TreeNode right) {
        this.left = null;
        this.data = data;
        this.right = right;
    }

    TreeNode(TreeNode left, int data, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}
