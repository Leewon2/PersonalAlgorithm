import java.util.*;

class Solution {
    static boolean[] isPrime;
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        makeIsPrime();
        for(int i=1; i<=numbers.length(); i++){
            perm(i,numbers,"");
        }
        return set.size();
    }
    
    private static void makeIsPrime(){
        isPrime = new boolean[10000000];
        isPrime[0] = true;
        isPrime[1] = true;
        for(int i=2; i<Math.sqrt(10000000); i++){
            if(!isPrime[i]){
                for(int j=i*i; j<10000000; j+=i){
                    isPrime[j] = true;
                }
            }
        }
    }
    
    private static void perm(int idx, String numbers, String compare){
        if(compare.length()==idx){
            if(!isPrime[Integer.parseInt(compare)])
                set.add(Integer.parseInt(compare));
            return;
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                perm(idx, numbers, compare+numbers.charAt(i));
                visited[i] = false;
            }
        }
        
    }
}