class Solution:
    def countPrimes(self, n: int) -> int:
        if n < 2:
            return 0
        li = [1] * (n)
        li[0] = 0
        li[1] = 0
        for i in range(2, int(sqrt(n) + 1)):
            if li[i] != 0: 
                for j in range(i * i, n, i):
                    li[j] = 0
            # print(li)
        return sum(li)


