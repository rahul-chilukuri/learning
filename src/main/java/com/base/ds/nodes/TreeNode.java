package com.base.ds.nodes;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left, right;

    public TreeNode(T data) {
        this.val = (T) data;
        left = null;
        right = null;
    }

    public TreeNode(TreeNode<T> left, T data) {
        this.left = left;
        this.val = data;
        this.right = null;
    }

    public TreeNode(T data, TreeNode<T> right) {
        this.left = null;
        this.val = data;
        this.right = right;
    }

    public TreeNode(TreeNode<T> left, T data, TreeNode<T> right) {
        this.val = data;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}