class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        // 43200이라 했을 때, 1시간은 1초에 1 이동, 1분은 1초에 60*12 이동, 
        int[] arr = new int[43200];
        // int startH = (h1*3600)%43200;
        // int startM = m1*720;
        // int startS = s1*720;
        
        int h = (h1*3600+m1*60+s1)%43200;
        int m = m1*720+s1*12;
        int s = s1*720;
        int startTime = h1*3600+m1*60+s1;
        int endTime = h2*3600+m2*60+s2;
        
        int cnt=0;
        boolean hCheck = true;
        boolean mCheck = true;
        if(s<h) hCheck = false;
        if(s<m) mCheck = false;
        
        if(h==s && h==m) {
            cnt++;
            hCheck = true;
            mCheck = true;
        }
        else if(h==s) {
            cnt++;
            hCheck = true;
        }
        else if(m==s) {
            cnt++;
            mCheck = true;
        }
        for(int i = startTime; i<=endTime; i++){

            if(s>=43200){
                if(h==m && !hCheck && !mCheck && s>=h){
                    cnt++;
                    h = h == 43200 ? 1 : h+1;
                    m = m == 43200 ? 12 : m+12;
                    s = 720;
                    if(h==1) hCheck = true;
                    else hCheck = false;
                    if(m==12) mCheck = true;
                    else mCheck = false;
                    continue;
                }else if(s>=h && !hCheck){
                    cnt++;
                    h = h == 43200 ? 1 : h+1;
                    m = m == 43200 ? 12 : m+12;
                    s = 720;
                    if(h==1) hCheck = true;
                    else hCheck = false;
                    if(m==12) mCheck = true;
                    else mCheck = false;
                    continue;
                }else if(s>=m && !mCheck){
                    cnt++;
                    h = h == 43200 ? 1 : h+1;
                    m = m == 43200 ? 12 : m+12;
                    s = 720;
                    if(h==1) hCheck = true;
                    else hCheck = false;
                    if(m==12) mCheck = true;
                    else mCheck = false;
                    continue;
                }
                s=0;
                hCheck = false;
                mCheck = false;
            }
            if(h>=43200){
                h=0;
            }
            if(m>=43200){
                m=0;
            }
            if(h==m && !hCheck && !mCheck && s>=h){
                cnt++;
                hCheck = true;
                mCheck = true;
            }else{
                if(!hCheck && s>=h){
                    hCheck = true;
                    cnt++;
                }
                if(!mCheck && s>=m){
                    mCheck = true;
                    cnt++;
                }
            }
            h += 1;
            m += 12;
            s += 720;
        }
        
        return cnt;
    }
}