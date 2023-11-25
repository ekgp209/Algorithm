package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[][] plane;
    static boolean[] visited;
    static int N, answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());           //국가의 수
            int M = Integer.parseInt(st.nextToken());       //비행기 종류
            answer = 0;

            plane = new int[N + 1][N + 1];
            visited = new boolean[N + 1];
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plane[a][b] = 1;
                plane[b][a] = 1;
            }
            BFS(1);
            System.out.println(answer - 1);
        }
    }

    static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=1; i<=N; i++){
                if(!visited[i] && plane[now][i] != 0){
                    visited[i] = true;
                    queue.add(i);
                }
            }
            answer++;
        }
    }
}
