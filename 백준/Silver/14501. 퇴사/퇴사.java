import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //날짜

        int[][] plan = new int[N + 1][2];
        int[] DP = new int[N + 2];      //최대 수입
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());   //기간
            plan[i][1] = Integer.parseInt(st.nextToken());   //금액
        }

        for(int i = N; i>0; i--){
            if(i + plan[i][0] > N + 1){     //i번째 상담을 퇴사일까지 끝낼 수 없는 경우
                DP[i] = DP[i + 1];
            }else{                          //퇴사일 안에 끝나는 경우
                DP[i] = Math.max(DP[i + 1], DP[i + plan[i][0]] + plan[i][1]);
            }
        }
        System.out.println(DP[1]);
    }
}