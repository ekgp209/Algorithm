import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        for(int i=1; i<=n; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[n + 1];
        DP[1] = stair[1];   //n이 1인 경우

        if(2 <= n){
            DP[2] = stair[1] + stair[2];
        }
        for(int i=3; i<=n; i++){
            if(i == 3){
                DP[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
                continue;
            }

            DP[i] = Math.max(DP[i-3] + stair[i-1], DP[i-2]) + stair[i];    //2칸 전 계단과 직전 계단 비교
        }

        System.out.println(DP[n]);
    }
}