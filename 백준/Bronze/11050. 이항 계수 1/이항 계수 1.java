import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] DP = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            DP[i][1] = i;   //i개에서 1개를 선택하는 경우의 수 = i개
            DP[i][0] = 1;   //i개에서 1개도 선택하지 않는 경우의 수 = 1개
            DP[i][i] = 1;   //i개에서 i개를 선택하는 경우의 수 = 1개
        }

        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){     //고르는 수가 전체 개수를 넘을 수 없음
                DP[i][j] = DP[i-1][j] + DP[i-1][j-1];   //조합 점화식
            }
        }
        System.out.println(DP[N][K]);
    }
}