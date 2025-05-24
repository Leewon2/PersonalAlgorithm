class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] a : queries){
            int s = a[0];
            int e = a[1];
            int k = a[2];
            for(int i=s; i<=e; i++){
                if(i%k==0) arr[i]++;
            }
        }
        return arr;
    }
}