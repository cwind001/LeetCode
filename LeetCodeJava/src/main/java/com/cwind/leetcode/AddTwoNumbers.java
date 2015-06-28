package com.cwind.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/27
 * Email: billchen01@163.com
 * #2 - Medium
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }
        ListNode result;
        ListNode cur;
        int curSum = l1.val + l2.val;
        boolean plusOne = false;
        if(curSum>9){
            curSum = curSum % 10;
            plusOne = true;
        }
        cur = new ListNode(curSum);
        result = cur;
        while (l1.next!=null&&l2.next!=null){
            l1 = l1.next;
            l2 = l2.next;

            if(plusOne){
                curSum = l1.val + l2.val + 1;
            }else {
                curSum = l1.val + l2.val;
            }
            if(curSum>9){
                curSum = curSum % 10;
                plusOne = true;
            }else {
                plusOne = false;
            }

            cur.next = new ListNode(curSum);
            cur = cur.next;
        }
        if(l1.next==null&&l2.next==null) {
            if(plusOne){
               cur.next = new ListNode(1);
            }
            return result;
        }else if(l1.next==null){
            while (l2.next!=null){
                l2 = l2.next;
                if(plusOne){
                    curSum = l2.val + 1;
                    if(curSum>9){
                        curSum = curSum %10;
                        plusOne = true;
                    }else {
                        plusOne = false;
                    }
                }else {
                    curSum = l2.val;
                    plusOne = false;
                }
                cur.next = new ListNode(curSum);
                cur = cur.next;
            }
        }else if(l2.next==null){
            while (l1.next!=null){
                l1 = l1.next;
                if(plusOne){
                    curSum = l1.val + 1;
                    if(curSum>9){
                        curSum = curSum%10;
                        plusOne = true;
                    }else {
                        plusOne = false;
                    }
                }else {
                    curSum = l1.val;
                    plusOne = false;
                }
                cur.next = new ListNode(curSum);
                cur = cur.next;
            }
        }
        if(plusOne){
            cur.next = new ListNode(1);
        }
        return result;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            if(this.next == null){
                return "val=" +val;
            }else {
                return "val="+val+"->"+this.next.toString();
            }
        }
    }

    public static void main(String[] args){
        ListNode cur;
        ListNode l1 = new ListNode(9);
        cur = l1;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(6);
        System.out.println("l1: "+l1);

        ListNode l2 = new ListNode(0);
//        cur = l2;
//        cur.next = new ListNode(8);
//        cur = cur.next;
//        cur.next = new ListNode(4);
        System.out.println("l2: "+l2);

        AddTwoNumbers tester = new AddTwoNumbers();
        ListNode l3 = tester.addTwoNumbers(l1, l2);
        System.out.println("l3: "+l3);
    }
}

