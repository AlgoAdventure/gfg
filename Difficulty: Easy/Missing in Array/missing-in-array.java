//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().missingNumber(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int missingNumber(int arr[]) {
        // code here
        int n=arr.length+1;
        int xor1=0;
        for(int i=1;i<=n;i++){
            xor1=xor1^i;
        }
        int xor2=0;
        for(int i=0;i<n-1;i++){
            xor2=xor2^arr[i];
        }
        return xor1^xor2;
    
    }
}