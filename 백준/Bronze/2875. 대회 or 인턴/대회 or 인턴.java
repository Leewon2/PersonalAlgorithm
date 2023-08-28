
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 여학생 수
        int N = sc.nextInt();
        // 남학생 수
        int M = sc.nextInt();
        // 최소 인턴 수
        int K = sc.nextInt();

        // 최대로 만들 수 있는 팀 찾기
        int maxTeamCnt = findTeam(N, M);


        // 새로운 N, M 생성
        int newN = N-2*maxTeamCnt;
        int newM = M-maxTeamCnt;


        // 현재 나머지 인원 찾기
        int restPeople = newN + newM;


        // 인턴쉽 차출
        while (restPeople < K) {
            restPeople+=3;
            maxTeamCnt-=1;
        }

        if(maxTeamCnt<=0) maxTeamCnt=0;
        System.out.println(maxTeamCnt);

    }

    private static int findTeam(int N, int M){
        return Math.min(N/2, M);
    }
}
