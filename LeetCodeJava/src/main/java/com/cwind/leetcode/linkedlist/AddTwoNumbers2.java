package com.cwind.leetcode.linkedlist;

public class AddTwoNumbers2 {

    public static ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        ListNode2 resultNode = new ListNode2();
        ListNode2 cur1 = l1, cur2 = l2, cur3 = resultNode;
        boolean plus = false;
        while (cur1 != null && cur2 != null) {
            int temp = cur1.val + cur2.val;
            if (plus) {
                temp += 1;
            }
            if (temp >= 10) {
                plus = true;
            } else {
                plus = false;
            }
            temp = temp % 10;
            cur3.next = new ListNode2(temp);
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur3 = cur3.next;
        }
        if (cur1 == null && cur2 != null) {
            cur3.next = plusOne(cur2);
        }
        if (cur2 == null && cur2 != null) {
            cur3.next = plusOne(cur1);
        }
        return resultNode.next;
    }

    private static ListNode2 plusOne(ListNode2 listNode2) {
        ListNode2 cur = listNode2;
        boolean plusOne = true;

        while (cur.next != null) {
            int temp = cur.val + 1;
            if (temp < 10) {
                cur.val = temp;
                break;
            } else {
                cur.val = temp % 10;
            }
            cur = cur.next;
        }

        return listNode2;
    }

    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * @param args
     */
    public static void main(String[] args) {
        ListNode2 cur1, cur2;
        ListNode2 l1 = new ListNode2(2);
        cur1 = l1;
        cur1.next = new ListNode2(4);
        cur1 = cur1.next;
        cur1.next = new ListNode2(3);
        System.out.println(l1);

        ListNode2 l2 = new ListNode2(5);
        cur2 = l2;
        cur2.next = new ListNode2(6);
        cur2 = cur2.next;
        cur2.next = new ListNode2(4);
        System.out.println(l2);

        ListNode2 result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}

class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        if (this.next == null) {
            return "val:" + this.val;
        } else {
            return "val:" + this.val + "->" + this.next.toString();
        }
    }
}