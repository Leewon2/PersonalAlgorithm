class Solution {
    public String solution(String my_string, int[] indices) {
        boolean[] out = new boolean[my_string.length()];
        for(int i=0; i<indices.length; i++){
            out[indices[i]] = true;
        }
        String answer = "";
        for(int i=0; i<out.length ;i++){
            if(out[i]) continue;
            answer+=my_string.charAt(i);
        }
        return answer;
    }
}