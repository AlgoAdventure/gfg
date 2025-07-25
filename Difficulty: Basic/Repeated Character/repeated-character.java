// User function Template for Java
class Solution {
    char firstRep(String s) {
        // your code here
        int n=s.length();
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            if(arr[s.charAt(i)-'a']>1){
                return s.charAt(i);
            }
        }
        return '#';
        
    }
}