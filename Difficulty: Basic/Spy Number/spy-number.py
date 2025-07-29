class Solution:
    def checkSpy(self, n):
        # code here
        total_sum = 0
        total_product = 1
    
        while n > 0:
            digit = n % 10
            total_sum += digit
            total_product *= digit
            n //= 10
        return total_sum == total_product
        
        
        
        
        
    
    
       
