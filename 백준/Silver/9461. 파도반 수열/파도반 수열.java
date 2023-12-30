import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());

            long[] DP = new long[N + 1];

            if(1 <= N && N <= 3){
                System.out.println(1);
                continue;
            }else if(N == 4 || N == 5){
                System.out.println(2);
                continue;
            }else if(6 <= N && N <= 8){
                System.out.println(N-3);
                continue;
            }else{
                DP[1] = 1; DP[2] = 1; DP[3] = 1;
                DP[4] = 2; DP[5] = 2;
                DP[6] = 3; DP[7] = 4; DP[8] = 5;

                for(int i=9; i<=N; i++){
                    DP[i] = DP[i-1] + DP[i-5];
                }
                System.out.println(DP[N]);
            }
        }
    }
}