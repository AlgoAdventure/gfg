// User function Template for Java

class Solution {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int arr[][]) {
        // code here
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                for(int j=0;j<arr[i].length;j++){
                    list.add(arr[i][j]);
                }
            }
            else{
                for(int j=arr[i].length-1;j>=0;j--){
                    list.add(arr[i][j]);
                }
            }
        }
        return list;
    }
}