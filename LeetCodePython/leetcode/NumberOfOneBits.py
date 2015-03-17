__author__ = 'wchen'

class NumberOfOneBits:
    # @param n, an integer
    # @return an integer
    def hammingWeight(self, n):
        sum = 0
        while(n != 0):
            sum += n & 1
            n = n >> 1
        return sum

tester = NumberOfOneBits()
print(tester.hammingWeight(32))