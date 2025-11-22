import java.util.*;
class Solution {
    Queue<Integer> q2 ;
    Queue<Integer> q;
    int n;
    int life;
    int co;
    public int solution(int coin, int[] cards) {
        n = cards.length;
        q = new LinkedList<>();
        q2 = new LinkedList<>();
        co = coin;
        life=0;
        for(int i=0; i<n/3; i++){
            if(q.size()>0 && q.contains((n+1)-cards[i])){
                life++;
                q.remove((n+1)-cards[i]);
            }else{
                q.offer(cards[i]);
            }
        }
        int idx = n/3;
        for(int i=idx; i<n; i+=2){
            calculate(cards[i]);
            calculate(cards[i+1]);
            if(life<1 && co>1){
                for(int card : q2){
                    if(q2.contains(n+1-card)){
                        life++;
                        co-=2;
                        q2.remove(card);
                        break;
                    }
                }
            }
            if(life<1) return (i-n/3)/2+1;
            life--;
        }
        return (n-n/3)/2+1;
    }
    
    private void calculate(int num){
        if(!q.isEmpty() && co>=1 && q.contains(n+1-num)){
            life++;
            co--;
        }else{
            q2.offer(num);
        }
    }
}