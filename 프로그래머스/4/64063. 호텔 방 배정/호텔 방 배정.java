import java.util.*;
class Solution {
    Map<Long, Long> map;
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        map = new HashMap<>();
        int idx=0;
        for(long room : room_number){
            answer[idx++] = dfs(room);
        }
        return answer;
    }
    private Long dfs(long room_num) {
        if (!map.containsKey(room_num)) {
            map.put(room_num, room_num + 1);
            return room_num;
        }
        long num = dfs(map.get(room_num));
        map.put(room_num, num);
        return num;
    }
}