class Solution {
    public int solution(int a, int d, boolean[] included) {
        
        int answer = 0;
        int s = a;
        for(int i=0; i<included.length; i++){
            if(included[i]) answer+=s;
            s+=d;
        }
        return answer;
    }
}