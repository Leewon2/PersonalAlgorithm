import java.util.*;
class Solution {
    public String[] solution(String[] s) {
        // 첫번째랑 두번째랑 0인 경우는 그대로 냅둬야할듯.
        String[] answer = new String[s.length];
        for(int i=0; i<s.length; i++){
            int cnt=0;
            Deque<Integer> dq = new ArrayDeque<>();
            for(int j=0; j<s[i].length(); j++){
                if(s[i].charAt(j)=='0'){
                    Queue<Integer> q = new LinkedList<>();
                    for(int k=0; k<2; k++){
                        if(dq.isEmpty()) break;
                        int prev = dq.pollLast();
                        if(prev==0) {
                            dq.offerLast(prev);
                            break;
                        }else{
                            q.offer(prev);
                        }
                    }
                    q.offer(0);
                    // 110이면 cnt늘리기
                    if(q.size()==3) cnt++;
                    // 110이 아니면 다시 dq에 넣기
                    else{
                        while(!q.isEmpty()){
                            dq.offerLast(q.poll());
                        }
                    }
                }
                else{
                    dq.offerLast(s[i].charAt(j)-'0');
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!dq.isEmpty()){
                // 0이면 그냥 넣기
                int poll = dq.poll();
                if(poll==0) sb.append("0");
                else{
                    if(dq.isEmpty()){
                        while(cnt-->0){
                            sb.append("110");
                        }
                        sb.append("1");
                    }else{
                        int secondPoll = dq.poll();
                        if(secondPoll==1){
                            while(cnt-->0){
                                sb.append("110");
                            }
                            sb.append("11");
                        }else{
                            sb.append("10");
                        }
                    }
                }
            }
            while(cnt-->0){
                sb.append("110");
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}