class Solution {
    public void sortByLength(String[] arr) {
        // code here
         Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        });
    
        
    }
}
