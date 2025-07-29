class Solution:
    def smallerAndLarge(self, s):
        # code here
        words = s.split()
        min_word = words[0]
        max_word = words[0]

        for word in words:
            if len(word) < len(min_word):
                min_word = word
            if len(word) >= len(max_word):
                max_word = word
        
            
        # For max word, update if longer or same length (overwrite to get last occurring)
        
        return [min_word, max_word]  

    