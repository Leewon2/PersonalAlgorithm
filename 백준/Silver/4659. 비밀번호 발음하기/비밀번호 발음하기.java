import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;
            int cnt=0;
            int cnt1=0;
            int cnt2=0;
            char before = str.charAt(0);
            if(str.charAt(0)=='a' ||str.charAt(0)=='e' ||str.charAt(0)=='o' ||str.charAt(0)=='i' ||str.charAt(0)=='u'){
                cnt++;
                cnt1++;
            }else cnt2++;
            boolean check = true;
            for (int i = 1; i < str.length(); i++) {
                if(str.charAt(i)==before && (str.charAt(i)=='e' || str.charAt(i)=='o')){
                    cnt++;
                    cnt1++;
                    cnt2=0;
                    if(cnt1>=3){
                        check = false;
                        break;
                    }
                }else if(str.charAt(i)==before){
                    check = false;
                    break;
                }
                else{
                    if(str.charAt(i)=='a' ||str.charAt(i)=='e' ||str.charAt(i)=='o' ||str.charAt(i)=='i' ||str.charAt(i)=='u'){
                        cnt++;
                        cnt2=0;
                        cnt1++;
                        if(cnt1>=3){
                            check = false;
                            break;
                        }
                    }else {
                        cnt2++;
                        cnt1=0;
                        if(cnt2>=3){
                            check = false;
                            break;
                        }
                    }
                }
                before = str.charAt(i);
            }
            if(cnt==0) check = false;
            if(check){
                sb.append("<").append(str).append("> ").append("is acceptable.").append("\n");
            }else{
                sb.append("<").append(str).append("> ").append("is not acceptable.").append("\n");
            }
        }
        System.out.println(sb);
    }
}