class Solution {
    public int[] solution(String my_string) {
        int[] arr = new int[52];
        for(int i=0; i<my_string.length(); i++){
            if(my_string.charAt(i)-'a'>=0){
                arr[my_string.charAt(i)-'a'+26]++;
            }else{
                arr[my_string.charAt(i)-'A']++;
            }
        }
        
        return arr;
    }
}