class Solution {
    String[] arr;
    int idx;
    String s;
    public int solution(String word) {
        arr = new String[10000];
        s = "AEIOU";
        idx = 0;
        int answer = 0;
        dfs("");
        for(int i=0; i<10000; i++){
            if(arr[i].equals(word)){
                answer = i;
                break;
            } 
        }
        return answer;
    }
    private void dfs(String str){
        arr[idx++] = str;
        if(str.length()==5) return;
        for(int i=0; i<5; i++){
            dfs(str+s.charAt(i));
        }
    }
}