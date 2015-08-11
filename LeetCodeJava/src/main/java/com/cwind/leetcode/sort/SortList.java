package com.cwind.leetcode.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/11
 * Email: billchen01@163.com
 * #148 - Medium
 */
public class SortList {

    /**
     * Requirement: O(nlogn) time and constant space complexity.
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        int nodeSum = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            nodeSum++;
        }
        tmp = head;
        for(int i=1; i<nodeSum/2; i++){
            tmp=tmp.next;
        }

        ListNode l1 = head;
        ListNode l2 = tmp.next;
        tmp.next=null;

        ListNode result = merge(sortList(l1), sortList(l2));
        return result;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cursor.next=l1;
                l1 = l1.next;
            }else{
                cursor.next=l2;
                l2=l2.next;
            }
            cursor = cursor.next;
        }
        if(l1!=null){
            cursor.next = l1;
        }else {
            cursor.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        SortList tester = new SortList();
        ListNode node = new ListNode(4);
        ListNode tmp = node;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(8);
        tmp = tmp.next;
        tmp.next = new ListNode(9);
        tmp = tmp.next;
        tmp.next = new ListNode(7);
        tmp = tmp.next;
        tmp.next = new ListNode(2);
        tmp = tmp.next;
        tmp.next = new ListNode(3);

//        tmp.next = new ListNode(2);
//        tmp = tmp.next;
//        tmp.next = new ListNode(3);
//        tmp = tmp.next;
//        tmp.next = new ListNode(1);

        tmp = node;
        System.out.println("Before sorting: ");
        while(tmp!=null){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }

        System.out.println();
        System.out.println("After sorting: ");
        ListNode result = tester.sortList(node);
        while(result!=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}