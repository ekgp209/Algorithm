package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[][] distance;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       //유저의 수
        int M = Integer.parseInt(st.nextToken());   //친구 관계의 수

        //인접행렬 초기화
        distance = new int[N + 1][N + 1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j){
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = 10000001;
                }
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        floydWarshall();
        
        int min = 10000001;
        int answer = -1;
        for(int i=1; i<=N; i++){
            int tmp = 0;
            for(int j=1; j<=N; j++){
                //각 행의 합이 i번째 사람의 케빈 베이컨 수
                tmp += distance[i][j];
            }
            
            if(min > tmp){
                min = tmp;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    static void floydWarshall(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}