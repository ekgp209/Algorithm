import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        int[][] D = new int[15][15];
        for(int i=0; i<15; i++){
            D[0][i] = i;   //0층의 i호에는 i명이 산다
            D[i][1] = 1;   //각 층의 1호는 무조건 1명
        }

        for(int i=1; i<15; i++){
            for(int j=1; j<15; j++){
                D[i][j] = D[i-1][j] + D[i][j-1];   //같은 층 옆 집은 아래층의 1~b-1까지의 합과 같음음
            }
        }

        for(int i=0; i<T; i++){
            int k = Integer.parseInt(br.readLine());    //층
            int n = Integer.parseInt(br.readLine());    //호

            System.out.println(D[k][n]);
        }
    }
}