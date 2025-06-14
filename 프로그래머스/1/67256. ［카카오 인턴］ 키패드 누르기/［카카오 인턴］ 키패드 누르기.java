import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        Map<Integer,Num> map = new HashMap<>();
        int idx=1;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                map.put(idx++,new Num(i,j));
            }
        }
        map.put(0,new Num(3,1));
        int leftR=3;
        int leftC=0;
        int rightR=3;
        int rightC=2;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer+="L";
                leftR=map.get(numbers[i]).r;
                leftC=map.get(numbers[i]).c;
            }else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
                answer+="R";
                rightR=map.get(numbers[i]).r;
                rightC=map.get(numbers[i]).c;
            }else{
                int r = map.get(numbers[i]).r;
                int c = map.get(numbers[i]).c;
                int lDist = Math.abs(leftR-r)+Math.abs(leftC-c);
                int rDist = Math.abs(rightR-r)+Math.abs(rightC-c);
                if(lDist<rDist){
                    answer+="L";
                    leftR=r;
                    leftC=c;
                }else if(rDist<lDist){
                    answer+="R";
                    rightR=r;
                    rightC=c;
                }else{
                    if(hand.equals("right")){
                        answer+="R";
                        rightR=r;
                        rightC=c;
                    }else{
                        answer+="L";
                        leftR=r;
                        leftC=c;
                    }
                }
                
            }
        }

        return answer;
    }
    private class Num{
        int r;
        int c;
        public Num(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}