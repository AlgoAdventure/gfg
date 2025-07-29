class Solution:
	def isDivBy7(self, n):
		# code here
		n = abs(n)

        # Apply the rule: keep reducing using "rest - 2 * last_digit"
        while n > 99:
            last_digit = int(str(n)[-1])
            rest = int(str(n)[:-1]) if len(str(n)) > 1 else 0
            n = rest - 2 * last_digit
            n = abs(n)

        # Brute force check for small number (up to 98)
        i = 0
        while i <= 98:
            if i == n:
                return True
            i += 7
        return False