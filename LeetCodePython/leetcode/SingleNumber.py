__author__ = 'wchen'

class SingleNumber:
    def __init__(self):
        pass

    def singleNumber(self, A):
        singleNum = A[0]
        for i in range(1,A.__len__()):
            singleNum = singleNum ^ A[i]
        return singleNum

intArray = [2,2,3,3,4,5,5,6,6]
# intArray = [1]
tester = SingleNumber()
print(tester.singleNumber(intArray))