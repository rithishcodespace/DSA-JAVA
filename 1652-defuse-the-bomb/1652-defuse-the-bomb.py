# brute force

class Solution(object):
    def decrypt(self, code, k):
        val = [0 for _ in range(len(code))]
        if k>0:
            for i in range(len(code)):
                val[i] = self.nextSum(code, i, k)
        elif k<0:
            for i in range(len(code)):
                val[i] = self.prevSum(code, i, k)

        return val

    def nextSum(self, code, idx, k):
        sum = 0
        while k>0:
            idx = (idx+1)%len(code)
            sum += code[idx]
            k -= 1
        return sum

    def prevSum(self, code, idx, k):
        sum = 0
        while k<0:
            idx = (idx-1+len(code))%len(code)
            sum += code[idx]
            k += 1
        return sum


        