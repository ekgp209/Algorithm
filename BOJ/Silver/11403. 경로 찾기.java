package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[][] distance;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 수

        //인접행렬 저장
        distance = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                distance[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floydWarshall();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floydWarshall(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(distance[i][k] == 1 && distance[k][j] == 1){
                        distance[i][j] = 1;
                    }
                }
            }
        }
    }
}
