class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        int len = 0;
        for(int i=0; i<finished.length; i++){
            if(!finished[i]) len++;
        }
        
        String[] answer = new String[len];
        int idx=0;
        for(int i=0; i<finished.length; i++){
            if(!finished[i]) answer[idx++]=todo_list[i];
        }
        return answer;
    }
}