package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[][] node;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int M, N, answer;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());    //테스트 케이스의 개수
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());   //밭의 가로길이
            N = Integer.parseInt(st.nextToken());   //밭의 세로길이
            int K = Integer.parseInt(st.nextToken());   //배추 위치의 개수

            node = new int[N][M];
            visited = new boolean[N][M];
            answer = 0;

            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                node[y][x] = 1;
            }
            
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(node[j][k] == 1 && !visited[j][k]){
                        DFS(j, k);
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    public static void DFS(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(0 <= newX && 0 <= newY & newX < N && newY < M){
                if(node[newX][newY] == 1 && !visited[newX][newY]){
                    DFS(newX, newY);
                }
            }
        }
    }
}
