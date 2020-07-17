package com.wilson.java.treenode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


class BuildTree1 {

    // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做

    private Map<Integer, Integer> reverses;
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }

        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    private TreeNode buildTree(int preL, int preR,
                               int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = reverses.get(pivot);

        // 这一步得画草稿，计算边界的取值，必要时需要解方程，并不难
        root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
        root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
        return root;
    }
}



class BuildTree2 {
    //在中序序列中查找与前序序列首结点相同元素的时候，如果使用 while 循环去一个个找效率很慢
    //这里我们借助数据结构 HashMap 来辅助查找，在开始递归之前把所有的中序序列的元素和它们所在的下标存到一个 map 中，这样查找的时间复杂度是 O(logn)
    HashMap<Integer, Integer> map = new HashMap<>();

    //保留的前序遍历
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        //在开始递归之前把所有的中序序列的元素和它们所在的下标存到一个 map 中
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        //二叉树的重要性质是递归
        return recursive(0,0,inorder.length-1);
    }

    /** 根据前序遍历序列和中序遍历序列重新组建二叉树
     * @param pre_root_idx 前序遍历的索引
     * @param in_left_idx  中序遍历左边界的索引
     * @param in_right_idx 中序遍历右边界的索引
     */
    public TreeNode recursive(int pre_root_idx, int in_left_idx, int in_right_idx) {

        //子树中序遍历为空，说明已经越过叶子节点，此时返回 nul
        if (in_left_idx > in_right_idx) {
            return null;
        }

        //root_idx是在前序里面的
        TreeNode root = new TreeNode(preorder[pre_root_idx]);

        // 通过 map ，根据前序的根节点的值，在中序中获取当前根的索引
        int idx = map.get(preorder[pre_root_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是 +1 ,左边边界就是 left ，右边边界是中间区分的idx-1
        root.left = recursive(pre_root_idx + 1, in_left_idx, idx - 1);

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        root.right = recursive(pre_root_idx + (idx-1 - in_left_idx +1)  + 1, idx + 1, in_right_idx);

        return root;
    }
}