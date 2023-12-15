import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] DP = new int[1001];
        for(int i=1; i<=n; i++){
            if(i < 3){
                DP[i] = i;
            }else{
                DP[i] = DP[i - 1] + DP[i - 2];
                DP[i] %= 10007;
            }
        }
        System.out.println(DP[n]);
    }
}