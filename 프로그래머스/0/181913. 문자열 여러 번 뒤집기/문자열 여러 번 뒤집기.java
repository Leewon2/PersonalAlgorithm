class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        char[] arr1 = my_string.toCharArray();
        char[] arr2 = my_string.toCharArray();
        for(int[] i : queries){
            int s = i[0];
            int e = i[1];
            int idx=0;
            for(int j=s; j<=e; j++){
                arr2[j]=arr1[e-idx++];
            }
            arr1=arr2.clone();
        }
        for(int i=0; i<arr1.length; i++){
            answer+=arr1[i];
        }
        return answer;
    }
}