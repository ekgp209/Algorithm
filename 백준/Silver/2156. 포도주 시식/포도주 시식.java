import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n+1];
        int[] DP = new int[n+1];

        for(int i=1; i<=n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        DP[1] = wine[1];

        if(1 < n){
            DP[2] = wine[1] + wine[2];
        }
        for(int i=3; i<=n; i++){
            DP[i] = Math.max(DP[i-1], Math.max(DP[i-2] + wine[i], DP[i-3] + wine[i-1] + wine[i]));
        }

        System.out.println(DP[n]);
    }
}