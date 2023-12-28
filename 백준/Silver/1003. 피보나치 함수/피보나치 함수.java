import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());

            int[][] DP = new int[N + 1][2];     //{0, 1} 호출횟수 저장
            DP[0][0] = 1; DP[0][1] = 0;
            
            if(0 < N){
                DP[1][0] = 0; DP[1][1] = 1;
                for(int j=2; j<=N; j++){
                    DP[j][0] = DP[j-1][0] + DP[j-2][0];
                    DP[j][1] = DP[j-1][1] + DP[j-2][1];
                }
            }
            
            System.out.println(DP[N][0] + " " + DP[N][1]);
        }
    }
}