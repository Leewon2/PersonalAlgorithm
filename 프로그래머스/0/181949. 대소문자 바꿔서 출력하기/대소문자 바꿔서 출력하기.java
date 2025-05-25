import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = a;
        String c = a;
        b=b.toUpperCase();
        c=c.toLowerCase();
        String result = "";
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)==b.charAt(i)){
                result +=c.charAt(i);
            }else{
                result +=b.charAt(i);
            }
        }
        System.out.println(result);
        
    }
}