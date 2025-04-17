//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.maxConsecutiveCount(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int maxConsecutiveCount(int[] arr) {
        // code here
        int count=0;
        int max=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                count=0;
            }
            else{
                count++;
            }
            if(count>max){
                max=count;
            }
        }
        count=0;
        int max2=0;
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                count=0;
            }
            else{
                count++;
            }
            if(count>max){
                max=count;
            }
        }
        return Math.max(max,max2);
        
    }
}
