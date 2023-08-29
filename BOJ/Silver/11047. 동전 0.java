package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
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
            if(coin[i] <= K){
                answer += (K/coin[i]);  //현재 동전의 가치로 구할 수 있는 최대의 개수 구하기
                K = K % coin[i];
            }  
        }
        System.out.println(answer);
    }
}
