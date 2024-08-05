import java.util.*;

class Solution {
    static boolean[] isPrime;
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        isPrime = new boolean[10000000];
        set = new HashSet<>();
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i=2; i<Math.sqrt(10000000); i++){
            if(!isPrime[i]){
                for(int j=i*i; j<10000000; j+=i){
                    isPrime[j] = true;
                }
            }
        }
        for(int i=1; i<=numbers.length(); i++){
            perm(i,numbers,"");
        }
        
        for(int s : set){
            if(!isPrime[s]) answer++;
        }
        
        
        return answer;
    }
    private static void perm(int idx, String numbers, String compare){
        if(compare.length()==idx){
            set.add(Integer.parseInt(compare));
            return;
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                String str = compare+numbers.charAt(i);
                perm(idx, numbers, str);
                visited[i] = false;
            }
        }
        
    }
}