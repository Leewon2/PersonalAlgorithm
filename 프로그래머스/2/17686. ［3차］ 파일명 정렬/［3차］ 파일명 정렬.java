import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        
        String[] arr = files.clone();
        for(int i=0; i<arr.length; i++){
            arr[i] = arr[i].toUpperCase();            
        }
        PriorityQueue<file> pq = new PriorityQueue<>((o1,o2)->{
            if(!o1.head.equals(o2.head)) return o1.head.compareTo(o2.head);
            else if(o1.number != o2.number) return o1.number-o2.number;
            return o1.idx-o2.idx;
        });
        for(int i=0; i<arr.length; i++){
            String head = "";
            int numberStart = 0;
            for(int j=0; j<arr[i].length(); j++){
                if(arr[i].charAt(j)-'0'<0 || arr[i].charAt(j)-'0'>9) head+=arr[i].charAt(j);
                else {
                    numberStart = j;
                    break;
                }
            }
            String number = "";
            for(int j=numberStart; j<arr[i].length(); j++){
                if(arr[i].charAt(j)-'0'>=0 && arr[i].charAt(j)-'0'<=9) number+=arr[i].charAt(j);
                else break;
            }
            int num = Integer.parseInt(number);
            pq.offer(new file(i,head,num));
        }        
        
        String[] answer = new String[files.length];
        int idx=0;
        while(!pq.isEmpty()){
            answer[idx++] = files[pq.poll().idx];
        }
        
        return answer;
    }
    private class file{
        int idx;
        String head;
        int number;
        public file(int idx, String head, int number){
            this.idx=idx;
            this.head=head;
            this.number=number;
        }
    }
}