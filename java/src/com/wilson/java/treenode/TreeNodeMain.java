package com.wilson.java.treenode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeNodeMain {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9};
        Tree tree=new Tree(arr, 0);
//
//        System.out.println("\n先序遍历");
//        tree.preOrderTraverse();
//        System.out.println("\n先序遍历（非递归）");
//        tree.nrPreOrderTraverse();
//
//        System.out.println("中序遍历");
//        tree.inOrderTraverse();
//        System.out.println("\n中序遍历（非递归）");
//        tree.nrInorderTraverse();
//
//
//        System.out.println("\n后序遍历");
//        tree.postOrderTraverse();
//        System.out.println("\n后序遍历（非递归）");
//        tree.nrPostOrderTraverse();
//
//
//
//        System.out.println("\n层次遍历");
//        tree.levelTraverse();






        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(); // Queue为接口

//        queue.add(1);
//        queue.add(2);
//        queue.add(3);


        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        while (queue.peek() != null) {
            System.out.println(queue.poll());
        }

    }

}
