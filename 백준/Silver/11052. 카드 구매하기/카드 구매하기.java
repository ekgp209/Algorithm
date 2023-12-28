import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //카드 수

        int[] cardPack = new int[N + 1];
        int[] DP = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            cardPack[i] = Integer.parseInt(st.nextToken());   //카드팩 별 가격
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                DP[i] = Math.max(DP[i], DP[i-j] + cardPack[j]);
            }
        }
        
        System.out.println(DP[N]);
    }
}