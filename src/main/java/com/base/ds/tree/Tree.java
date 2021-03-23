package com.base.ds.tree;

import com.base.ds.nodes.TreeNode;

/**
 * Max number of nodes at a level(n) is 2ⁿ
 * 
 * Max possible number of nodes in a tree are (2ⁿ-1) where n is height/depth
 * 
 * If there are n nodes in a tree, the min height of the tree is log₂(n+1)
 * 
 * In Binary tree where every node has 0 or 2 children, the number of leaf nodes
 * is always one more than nodes with two children.
 */
public class Tree {
    public static void main(String[] args) {
        TreeNode<Integer> root, left, right, ll, lr, rl, rr;
        
        ll = new TreeNode<Integer>(40);
        lr = new TreeNode<Integer>(50);
        rl = new TreeNode<Integer>(60);
        rr = new TreeNode<Integer>(70);

        left = new TreeNode<Integer>(ll,20,lr);
        right = new TreeNode<Integer>(rl,30,rr);
        root = new TreeNode<Integer>(left, 10, right);
        System.out.println("\npreOrder");
        preOrder(root);
        System.out.println("\ninOrder");
        inOrder(root);
        System.out.println("\npostOrder");
        postOrder(root);
    }

    static void preOrder(TreeNode<Integer> node) {
        if (node == null)
            return;

        System.out.print(node.val + "->");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode<Integer> node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.val + "->");
        inOrder(node.right);
    }

    static void postOrder(TreeNode<Integer> node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "->");
    }
}
