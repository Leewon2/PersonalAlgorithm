class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];
            boolean[] use = new boolean[4];
            boolean check = true;
            str = str.replace("aya","0");
            str = str.replace("ye","1");
            str = str.replace("woo","2");
            str = str.replace("ma","3");
            if(str.length()>4) continue;
            for(int j=0; j<str.length(); j++){
                char k = str.charAt(j);
                if(k>='0' && k<='4'){
                    int num = Character.getNumericValue(k);
                    if(use[num]) {
                        check = false;
                        break;
                    }
                    use[num] = true;
                }else {
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}