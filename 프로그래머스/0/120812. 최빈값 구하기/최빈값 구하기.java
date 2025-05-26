import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arr = new int[1000];
        for(int i : array){
            arr[i]++;
        }
        int size=0;
        int max=-1;
        for(int i=0; i<1000; i++){
            if(arr[i]>max){
                size=1;
                max=arr[i];
                answer=i;
            }else if(arr[i]==max){
                size++;
            }
        }
        return size>=2 ? -1 : answer;
    }
}