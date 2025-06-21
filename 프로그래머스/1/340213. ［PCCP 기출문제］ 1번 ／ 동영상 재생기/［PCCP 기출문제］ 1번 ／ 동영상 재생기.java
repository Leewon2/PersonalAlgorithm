class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // PREV : 10초 전 or 처음
        // next : 10초 후 or 끝
        // opstart보다 >= opend보다 <= 인경우 opend 위치로 이동
        String[] videolen = video_len.split(":");
        int totalLen = Integer.parseInt(videolen[0])*60+Integer.parseInt(videolen[1]);
        String[] po = pos.split(":");
        int now = Integer.parseInt(po[0])*60+Integer.parseInt(po[1]);
        String[] ops = op_start.split(":");
        String[] ope = op_end.split(":");
        int start = Integer.parseInt(ops[0])*60+Integer.parseInt(ops[1]);
        int end = Integer.parseInt(ope[0])*60+Integer.parseInt(ope[1]);
        for(String s : commands){
            if(now>=start && now<=end) now = end;
            if(s.equals("next")){
                now = Math.min(totalLen,now+10);
            }else if(s.equals("prev")){
                now = Math.max(0,now-10);
            }
            
        }
        if(now>=start && now<=end) now = end;
        int hour = now/60;
        int minute = now%60;
        if(hour<10){
            answer+="0"+Integer.toString(hour)+":";
        }else{
            answer+=Integer.toString(hour)+":";
        }
        if(minute<10){
            answer+="0"+Integer.toString(minute);
        }else{
            answer+=Integer.toString(minute);
        }
        return answer;
    }
}