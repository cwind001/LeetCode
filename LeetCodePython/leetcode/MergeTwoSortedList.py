"""
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __repr__(self):
        ll = []
        cur = self
        while cur:
            ll.append(cur.val)
            cur=cur.next
        return str(ll)

class MergeTwoSortedList:
    def __init__(self):
        pass
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):  # linear in sum of length of two lists
        head, put_away = None, None
        while l1 or l2:
            # find the elem to put away
            if not l1:
                to_put_away = l2
                l2 = l2.next
            elif not l2:
                to_put_away = l1
                l1 = l1.next
            else:
                if l1.val <= l2.val:
                    to_put_away = l1
                    l1 = l1.next
                else:
                    to_put_away = l2
                    l2 = l2.next
            # add link if not the first put_away
            if put_away:
                put_away.next = to_put_away  # add link
                put_away = to_put_away
            # init
            else:
                put_away = to_put_away
                head = put_away
        return head

tester = MergeTwoSortedList()
print tester.mergeTwoLists(ListNode(0), ListNode(1))
m = {}
n = {}
print tester.mergeTwoLists(m, n)
m = ListNode(0)
m.next = ListNode(4)
n = ListNode(1)
n.next = ListNode(2)
print tester.mergeTwoLists(m, n)