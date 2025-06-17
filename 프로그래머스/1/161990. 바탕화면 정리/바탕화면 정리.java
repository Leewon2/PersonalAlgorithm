class Solution {
    public int[] solution(String[] wallpaper) {
        int minR=500;
        int minC=500;
        int maxR=0;
        int maxC=0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i+1);
                    maxC = Math.max(maxC, j+1);
                }
            }
        }
        int[] answer = {minR,minC,maxR,maxC};
        return answer;
    }
}