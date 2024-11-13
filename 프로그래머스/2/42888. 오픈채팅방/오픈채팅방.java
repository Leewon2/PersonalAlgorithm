import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> name = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<record.length; i++){
            String[] arr = record[i].split(" ");
            if(arr[0].equals("Change")){
                name.put(arr[1],arr[2]);
            }else{
                list.add(arr[0]+"@"+arr[1]);
                if(arr[0].equals("Enter")){
                    name.put(arr[1],arr[2]);
                }
            }
        }
        String[] answer = new String[list.size()];
        int idx=0;
        for(int i=0; i<list.size(); i++){
            String[] arr = list.get(i).split("@");
            if(arr[0].equals("Enter")){
                answer[idx++] = name.get(arr[1])+"님이 들어왔습니다.";
            }else{
                answer[idx++] = name.get(arr[1])+"님이 나갔습니다.";
            }
        }
        return answer;
    }
}