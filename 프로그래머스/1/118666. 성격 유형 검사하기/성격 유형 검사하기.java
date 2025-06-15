import java.util.*;
class Solution {
    char[][] arr;
    Map<Character,Integer> map;
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        map = new HashMap<>();
        arr = new char[4][2];
        arr[0][0]='R';arr[0][1]='T';
        arr[1][0]='C';arr[1][1]='F';
        arr[2][0]='J';arr[2][1]='M';
        arr[3][0]='A';arr[3][1]='N';
        for(int i=0; i<survey.length; i++){
            if(choices[i]==4) continue;
            makeCharacter(survey[i].charAt(0),survey[i].charAt(1),choices[i]);
        }
        for(int i=0; i<4; i++){
            int x = map.getOrDefault(arr[i][0],0);
            int y = map.getOrDefault(arr[i][1],0);
            answer+= x>=y ? arr[i][0] : arr[i][1];
        }

        return answer;
    }
    
    private void makeCharacter(char x, char y, int num){
        for(int i=0; i<4; i++){
            if(arr[i][0]==x || arr[i][0]==y){
                if(num<4){
                    map.put(x,map.getOrDefault(x,0)+4-num);
                }else{
                    map.put(y,map.getOrDefault(y,0)+num-4);
                }
                break;
            }
        }
    }
}