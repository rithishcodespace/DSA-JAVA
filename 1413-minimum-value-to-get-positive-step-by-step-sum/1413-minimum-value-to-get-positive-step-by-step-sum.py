# brute force

class Solution(object):
    def minStartValue(self, nums):
        for i in range(1,5000):
            startValue = i
            flag = True
            for num in nums:
                startValue += num
                if startValue < 1:
                    flag = False
                    break
            if flag:
                return i
        return -1
        