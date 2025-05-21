class Solution {
    public int[] solution(String myString) {
        myString+="a";
        String[] arr = myString.split("x");
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i].length();
        }
        answer[arr.length-1]--;
        return answer;
    }
}