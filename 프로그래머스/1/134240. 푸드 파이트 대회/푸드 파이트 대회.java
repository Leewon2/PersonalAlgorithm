class Solution {
    public String solution(int[] food) {
        String answer = "";
        String front="";
        String back="";
        
        for(int i=1; i<food.length; i++){
            for(int j=0; j<food[i]/2; j++){
                front+=i;
                back=i+back;
            }
        }
        return front+"0"+back;
    }
}