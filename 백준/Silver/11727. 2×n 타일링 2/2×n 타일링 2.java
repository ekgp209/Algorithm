import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N + 1];
        DP[1] = 1;

        if(2 <= N){
            DP[2] = 3;

            for(int i=3; i<=N; i++){
                DP[i] = (DP[i-2]*2 + DP[i-1]) % 10007;
            }
        }

        System.out.println(DP[N]);
    }
}