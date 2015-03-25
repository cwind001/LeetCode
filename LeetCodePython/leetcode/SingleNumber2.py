__author__ = 'wchen'

class SingleNumber2:
    def __init__(self):
        pass

    def singleNumber(self, A):
        ones = 0
        twos = 0
        threes = 0
        for i in range(0, A.__len__()):
            twos |= ones & A[i]
            ones = ones ^ A[i]
            threes = ones & twos
            twos = twos & ~threes
            ones = ones & ~threes
        return ones

intArray = [2,2,2,3,3,3,4,5,5,5,6,6,6]
tester = SingleNumber2()
print(tester.singleNumber(intArray))