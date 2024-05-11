
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            arr[i] = new Student(name, day, month, year);
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.year != o2.year) {
                return o1.year - o2.year;
            } else if (o1.month != o2.month) {
                return o1.month - o2.month;
            }else{
                return o1.day - o2.day;
            }
        });
        System.out.println(arr[n - 1].name);
        System.out.println(arr[0].name);

    }

    private static class Student{
        String name;
        int day;
        int month;
        int year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day=day;
            this.month=month;
            this.year = year;
        }
    }

}
