package com.cwind.leetcode.linkedlist;

/**
 * Created with IntelliJ IDEA.
 * User: wchen
 * Date: 4/21/15
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val>l2.val){
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }

    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(4);
        MergeTwoSortedLists tester = new MergeTwoSortedLists();
        ListNode result = tester.mergeTwoLists(n1, n2);
        while(result!=null){
            System.out.print(result.val+", ");
            result = result.next;
        }
    }
}
