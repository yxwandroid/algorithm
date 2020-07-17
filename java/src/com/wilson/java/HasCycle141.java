package com.wilson.java;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 思路
 * 创建一个hashSet节点集合，遍历链表中的节点，每次遍历都去判断集合中是否存在该节点，
 * 如果不存在，就存入集合，如果存在则说明链表有环\
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/lian-biao-you-huan-zui-jia-jie-da-by-tinet-shenjg/
 */
class HasCycle {

    public static void main(String[] arg) {
//        入：head = [3,2,0,-4], pos = 1

        ListNode listNode1 = new ListNode(3);

        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(0);
        ListNode listNode4 = new ListNode(-4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        boolean b = hasCycle(listNode1);
        boolean b2 = hasCycle2(listNode1);
        System.out.println(b);
        System.out.println(b2);
    }


    public static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }


    /**
     * 方法二：双指针-快慢指针(快慢指针来模拟追击问题，只要存在环状结构，就一定可以追上)
     * 除了两个指针，没有使用额外的存储空间，所以空间复杂度为O(1)
     * 拓展：求出环的长度(指针第一次相遇到第二次相遇之间，指针的移动次数就是环的长度)
     */
    public static boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null)
            return false; // 0或1个节点不存在环
        ListNode slow = head;
        ListNode fast = head;

        slow = slow.next; // slow每次移动一位

        if (fast.next == null || fast.next.next == null)
            return false;

        fast = fast.next.next;// fast每次移动二位


        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else{
                return false;
            }
        }
        return true;
    }


}

