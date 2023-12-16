import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int d = sc.nextInt();
        int hh = d/3600;
        int mm =(d-hh*3600)/60;
        int ss = (d-hh*3600-mm*60);
//        System.out.println(ss);
        int resS = s+ss;
        if(resS>=60){
            resS-=60;
            mm++;
        }
        int resM = mm+m;
        if(resM>=60){
            resM-=60;
            hh++;
        }
        int resH = (h+hh)%24;
        System.out.println(resH+" "+resM+" "+resS);


    }
}
