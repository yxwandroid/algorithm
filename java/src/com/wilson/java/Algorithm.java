package com.wilson.java;

import java.util.List;
import java.util.Stack;

public class Algorithm {


    public static void main(String[] args) {

    }


    //倒序打印链表  123  to   321


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
            ListNode pop = stack.pop();
            print[i] = pop.index;
        }

        return print;
    }


    //    链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-b/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int[] reversePrint2(ListNode head) {
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


    public int[] reversePrint32(ListNode head) {
        Stack<ListNode> listNodes = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            listNodes.push(temp);
            temp = temp.next;
        }
        int size = listNodes.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            ListNode pop = listNodes.pop();
            print[i] = pop.index;

        }

        return print;


    }

}
