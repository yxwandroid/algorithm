package com.wilson.java.code;
//24. 两两交换链表中的节点
public class SwapPair24 {

    public static void main(String[] arg){


        ListNode1 listNode1 = new ListNode1(1);

        ListNode1 listNode2 = new ListNode1(2);
        ListNode1 listNode3 = new ListNode1(3);
        ListNode1 listNode4 = new ListNode1(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;

        ListNode1 listNode11 = swapPairs(listNode1);
        System.out.println(listNode1);


    }

    //链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/

    public static ListNode1 swapPairs(ListNode1 head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode1 next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

//    https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/di-gui-he-fei-di-gui-liang-chong-jie-fa-by-reedf-5/
    public ListNode1 Swap(ListNode1 head){
        if (head==null||head.next==null)
            return  head;

        ListNode1 tempNode = new ListNode1(-1);

        ListNode1  res = tempNode;
        while (head!=null&&head.next!=null){
            //
            tempNode.next = head.next;
            head.next = head.next.next;
            tempNode.next.next=head;
            //第一轮循环结束 进行第二轮循环
            tempNode= tempNode.next.next;
            head = head.next;
        }

         return res.next;

    }


}



class ListNode1 {
    ListNode1 next;
    int index;


    public ListNode1(int index) {
        this.index = index;
    }

    public ListNode1() {
    }
}

