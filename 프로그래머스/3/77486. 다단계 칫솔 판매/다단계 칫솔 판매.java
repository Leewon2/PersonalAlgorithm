import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // <자식, 자식 idx, 부모, 부모 idx 순으로 들어가야함>
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++){
            idxMap.put(enroll[i],i);
        }
        Map<String, Name> map = new HashMap<>();
        for(int i=0; i<referral.length; i++){
            if(referral[i].equals("-")){
                map.put(enroll[i], new Name("-",-1));
            }else{
                map.put(enroll[i], new Name(referral[i],idxMap.get(referral[i])));
            }
        }
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<seller.length; i++){
            int cnt = amount[i]*100;
            String child = seller[i];
            int idx = idxMap.get(child);
            while(true){
                // 부모 정보 불러오기
                Name n = map.get(child);
                int parentCnt = cnt/10;
                if(cnt<10){
                    answer[idx]+=cnt;
                    
                }else{
                    answer[idx]+=cnt-parentCnt;

                }
                
                if(n.name.equals("-")){
                    break;
                }
                else{
                    child = n.name;
                    idx = idxMap.get(child);
                }
                cnt*=0.1;
                
                if(cnt<1) break;
                
                
            }
        }
        
        
        
        
        
        return answer;
    }
    
    private static class Name{
        String name;
        int idx;
        public Name(String name, int idx){
            this.name=name;
            this.idx=idx;
        }
    }
}