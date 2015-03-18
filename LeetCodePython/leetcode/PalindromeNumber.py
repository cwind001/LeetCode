__author__ = 'wchen'

class PalindromeNumber:
    def __init__(self):
        pass

    def isPalindrome(self, x):
        if (x < 0):
            return False
        originNum = x
        num = x % 10
        x /= 10;
        while (x!=0):
            num *= 10
            num += x%10
            x /= 10
        return num==originNum

tester = PalindromeNumber()
print(tester.isPalindrome(112))
print(tester.isPalindrome(121))
print(tester.isPalindrome(-2147483648))
