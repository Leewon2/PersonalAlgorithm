import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] res = new int[id_list.length];
        Map<String, List<String>> map = new HashMap<>();
        Map<String, List<String>> map2 = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            List<String> list = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            list.add(Integer.toString(i));
            list2.add(Integer.toString(i));
            map.put(id_list[i],list);
            map2.put(id_list[i],list2);
        }
        
        for(String s : report){
            String[] arr = s.split(" ");
            List<String> list = map.get(arr[0]);
            if(list.contains(arr[1])) continue;

            System.out.println();
            // 신고당한 사람 list에 신고한 사람을 list2에 저장
            List<String> list2 = map2.get(arr[1]);
            // 날 신고한 사람 = arr[0]
            list2.add(arr[0]);
            map2.put(arr[1],list2);
            
            // 내가 신고한 사람 = arr[1]
            list.add(arr[1]);
            map.put(arr[0],list);
            answer[Integer.parseInt(list2.get(0))]++;
            res[Integer.parseInt(list2.get(0))]++;
        }
        int[] res2 = new int[res.length];
        for(int i=0; i<res.length; i++){
            if(res[i]>=k){
                // 나를 신고한 사람들의 목록을 불러옴
                List<String> list = map2.get(id_list[i]);
                for(int j=1; j<list.size(); j++){
                    // list2 = 나를 신고한 사람
                    List<String> list2 = map.get(list.get(j));

                    res2[Integer.parseInt(list2.get(0))]++;
                }
            }
        }
        return res2;
    }
}