import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        String str ="";
        for(int i=0; i<myStr.length(); i++){
            if(myStr.charAt(i)=='a' || myStr.charAt(i)=='b' || myStr.charAt(i)=='c'){
                if(!str.equals("")) list.add(str);
                str="";
            }else{
                str+=myStr.charAt(i);
            }
        }
        if(!str.equals("")) list.add(str);
        if(list.size()==0) list.add("EMPTY");
        return list.toArray(new String[0]);
    }
}