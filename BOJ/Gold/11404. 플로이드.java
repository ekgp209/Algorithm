package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[][] distance;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());   //도시의 수
        int m = Integer.parseInt(br.readLine());   //버스의 수

        //인접행렬 초기화
        distance = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i == j){
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = 10000001;
                }                    
            }
        }
        
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());       //출발도시
            int e = Integer.parseInt(st.nextToken());       //도착도시
            int w = Integer.parseInt(st.nextToken());       //비용

            if(distance[s][e] > w){
                distance[s][e] = w;
            }
        }

        floydWarshall();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(distance[i][j] == 10000001){
                    System.out.print("0 ");
                }else{
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    static void floydWarshall(){
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    // 같은 의미
                    // if(distance[i][j] > distance[i][k] + distance[k][j]){
                    //     distance[i][j] = distance[i][k] + distance[k][j];
                    // }
                }
            }
        }
    }
}
