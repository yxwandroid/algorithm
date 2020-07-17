package com.wilson.java.code;

import com.wilson.java.ListNode;

import java.util.Stack;

//倒序打印链表
public class ReversePrintNode {


    public static void main(String[] args) {

    }

    //https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/
    //倒序打印链表
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().index;
        }
        return print;
    }


}
