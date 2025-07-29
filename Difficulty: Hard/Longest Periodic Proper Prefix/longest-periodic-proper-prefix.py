class Solution:
    def getLongestPrefix(self, s):
        # code here
        n = len(s)
        for l in range(n - 1, 0, -1):
            prefix = s[:l]
            repeated = prefix * ((n + l - 1) // l)
            if repeated.startswith(s):
                return l
        return -1
        
