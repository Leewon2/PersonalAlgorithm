import java.util.*;
class Solution {
    List<Integer> list;
    final String[] zeroFive = {"0","5"};
    public int[] solution(int l, int r) {
        list = new ArrayList<>();
        perm(Integer.toString(r).length(),"",l,r);
        if(list.size()==0) list.add(-1);
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
    private void perm(int len, String str, int l, int r){
        if(str.length()>len) return;
        if(str.length()<=len && str.length()!=0){
            int num = Integer.parseInt(str);
            if(str.charAt(0)=='0') return;
            if(num>=l && num<=r) list.add(num);
        }
        for(int i=0; i<2; i++){
            perm(len, str+zeroFive[i],l,r);
        }
    }
}