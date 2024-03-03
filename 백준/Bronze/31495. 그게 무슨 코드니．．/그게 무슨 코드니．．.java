
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.length()<=2){
            System.out.println("CE");
            System.exit(0);
        }
        if(str.charAt(0)=='"' && str.charAt(str.length()-1)=='"'){
            if(str.length()==2) System.out.println("CE");
            else System.out.println(str.substring(1,str.length()-1));
        }else{
            System.out.println("CE");
        }
    }
}
