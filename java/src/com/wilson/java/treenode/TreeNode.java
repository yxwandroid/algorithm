package com.wilson.java.treenode;

// 树的节点
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;


    public TreeNode(int val) {
        super();
        this.val = val;
    }


    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public int getVal() {
        return val;
    }
}