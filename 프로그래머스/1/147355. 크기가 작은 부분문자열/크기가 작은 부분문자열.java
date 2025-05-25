class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long[] arr = new long[t.length()-p.length()+1];
        for(int i=0; i<t.length()-p.length()+1; i++){
            String str = t.substring(i,i+p.length());
            arr[i] = Long.parseLong(str);
        }
        long pp = Long.parseLong(p);
        for(long i : arr){
            if(i<=pp) answer++;
        }
        return answer;
    }
}