#coding=utf-8

"""
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2.
Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
"""


class Solution(object):
    @staticmethod
    def two_sum_n_squared(numbers, target):
        # brute force method
        N = len(numbers)
        for i in range(N):
            for j in range(N):
                if numbers[i]+numbers[j] == target and i != j:
                    # don't forget the parenthesis, or will report compile error with
                    # "too many values to unpack"
                    smaller, bigger = (i+1, j+1) if i+1 < j+1 else (j+1, i+1)
                    return smaller, bigger

    @staticmethod
    def two_sum_n(numbers, target):
        N = len(numbers)
        num_dict = {}
        for i in range(N):
            num_dict[numbers[i]] = i
        for i in range(N):
            to_find = target - numbers[i]
            # remember to rule self out
            if to_find in num_dict and num_dict[to_find] != i:
                smaller, bigger = i+1, num_dict[to_find] + 1
                smaller, bigger = (smaller, bigger) if smaller<bigger else (bigger, smaller)
                return smaller, bigger
        return -1, -1

    @staticmethod
    def two_sum_n_refined(num, target):
        num_dict = {}
        for i in range(len(num)):
            partner = target - num[i]
            # no need to rule self out here, cause you won't encounter yourself again.
            if partner in num_dict:
                # 1) by the time find your partner, you are already in dictionary,
                # and you are always the prior one.
                # 2) no need to deal with duplicates, duplicates that is solution to <target> will
                # be properly handled; not part of solution, the value of the <num_dict> will be
                # the later duplication's index, but that does not matter.
                return num_dict[partner]+1, i+1
            else:
                num_dict[num[i]] = i
        return -1, -1

    """
    Follow up Question:
    What if the given input is already sorted in ascending order?
    """
    @staticmethod
    # Input: num is sorted
    def two_sum_2_nlogn(num, target):
        import bisect
        N = len(num)
        for i in range(N):
            partner = target - num[i]
            insertion_point = bisect.bisect_left(num, partner)
            # use binary search, if found it; rule self out
            if insertion_point != N and num[insertion_point] == partner and i != insertion_point:
                smaller = i+1
                bigger = insertion_point + 1
                smaller, bigger = (smaller, bigger) if smaller<bigger else (bigger, smaller)
                return smaller, bigger
        return -1, -1

    @staticmethod
    # Input: num is sorted
    def two_sum_2_n_refined(num, target):
        N = len(num)
        prior, later = 0, N-1
        # two pointer pointing to ith and jth elements, num[i] and num[j],
        # num[i]+num[j] can only be >,<,== target.
        for _ in range(N-1):
            if num[prior] + num[later] == target:
                return prior+1, later+1
            elif num[prior] + num[later] > target:
                later -= 1
            else:
                prior += 1
        return -1, -1


class TwoSum(object):
    """
    Follow up Question: [HARDER--much more details to consider]
    Design and implement a TwoSum class. It should support the following operations: add
    and find.
    add(input) – Add the number input to an internal data structure.
    find(value) – Find if there exists any pair of numbers which sum is equal to the value.
    For example,
    add(1); add(3); add(5); find(4)  true; find(7)  false
    """
    def __init__(self):
        self.numbers = {}  # <key=number value>: <value=1-based index, could be list if duplicate>
        self.count = 1

    # store input into a hash map, handle duplicates carefully
    def add_constant_runtime(self, x):
        # if duplicated and still not a list, change the value to a list.
        # Do NOT re-list it!!!
        if x in self.numbers and type(self.numbers[x]) is int:
            self.numbers[x] = [self.numbers[x]]
            self.numbers[x].append(self.count)
        elif x in self.numbers:
            self.numbers[x].append(self.count)
        else:
            self.numbers[x] = self.count
        self.count += 1

    # find target-num[i] in hash map
    def find_n_runtime(self, target):
        for elem in self.numbers.iterkeys():
            partner = target - elem
            # edge case: duplicates adds up to target
            if partner == elem and partner in self.numbers and type(self.numbers[elem]) is list:
                return self.numbers[elem][0], self.numbers[elem][1]
            # normal case: found it.
            if partner in self.numbers:
                if type(self.numbers[elem]) is int:
                    prior = self.numbers[elem]
                else:
                    prior = self.numbers[elem][0]
                if type(self.numbers[partner]) is int:
                    later = self.numbers[partner]
                else:
                    later = self.numbers[partner][0]
                return (prior, later) if prior<later else (later, prior)
        return -1, -1

if __name__ == "__main__":
    print Solution.two_sum_n_refined([3,2,4], 6)  # (2,3)
    print Solution.two_sum_n_refined([3,2,2], 4)  # (2,3)
    print Solution.two_sum_n_refined([3,2,2,2,2,2,2,2,2,2,2,2,2,2], 4)  # (2,3)
    print Solution.two_sum_n_refined([3], 4)  # (-1,-1)

    # for follow up question 2, with input num array already sorted in ascending order
    print Solution.two_sum_2_nlogn([2,3,4], 6)  # (1,3)
    print Solution.two_sum_2_nlogn([2,2,3], 4)  # (1,2), should not be (1,1)
    print Solution.two_sum_2_nlogn([2,2,2,2,2,2,2,2,2,2,2,2,3], 4)  # (1,2)
    print Solution.two_sum_2_nlogn([3], 4)  # (-1,-1)

    print Solution.two_sum_2_n_refined([2,3,4], 6)  # (1,3)
    print Solution.two_sum_2_n_refined([2,2,3], 4)  # (1,2), should not be (1,1)
    print Solution.two_sum_2_n_refined([2,2,2,2,2,2,2,2,2,2,2,2,3], 4)  # (1,2)
    print Solution.two_sum_2_n_refined([3], 4)  # (-1,-1)

    # for follow up question 3: data structure design
    two_sum = TwoSum()
    for i in [2,3,4]:
        two_sum.add_constant_runtime(i)
    print two_sum.find_n_runtime(6)  # (1,3)
    for i in [2,2,2,2,2,2,2,2,2,2,2,2,3]:
        two_sum.add_constant_runtime(i)
    print two_sum.find_n_runtime(4)  # (1,4)
    for i in [4]:
        two_sum.add_constant_runtime(i)
    print two_sum.find_n_runtime(14)  # (-1,-1)