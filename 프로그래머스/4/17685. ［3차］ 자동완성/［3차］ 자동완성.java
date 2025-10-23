import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);
        for(int i=0; i<words.length; i++){
            int idx=1;
            if(i==0){
                String str = words[i];
                String next = words[i+1];
                for(int j=0; j<str.length(); j++){
                    if(j>= next.length() || str.charAt(j)!=next.charAt(j)) break;
                    idx++;
                }
                answer+=Math.min(idx,str.length());
                
            }else if(i==words.length-1){
                String str = words[i];
                String pre = words[i-1];
                for(int j=0; j<str.length(); j++){
                    if(j>=pre.length() || str.charAt(j)!=pre.charAt(j)) break;
                    idx++;
                }
                answer+=Math.min(idx,str.length());
            }else{
                String str = words[i];
                String pre = words[i-1];
                String next = words[i+1];
                for(int j=0; j<str.length(); j++){
                    if(j>=next.length() || str.charAt(j)!=next.charAt(j)) break;
                    idx++;
                }
                int max = idx;

                idx=1;
                for(int j=0; j<str.length(); j++){
                    if(j>=pre.length() || str.charAt(j)!=pre.charAt(j)) break;
                    idx++;
                }
                max = Math.max(max, idx);
                answer+=Math.min(max,str.length());
            }

        }

        return answer;
    }
}