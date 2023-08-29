package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047_동전0 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //동전 종류의 수
        int K = Integer.parseInt(st.nextToken());   //가치의 합

        int[] coin = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int i=N-1; i>=0; i--){
            while(coin[i] <= K){
                K = K - coin[i];
                answer++;
            }  
        }
        System.out.println(answer);
    }
}
