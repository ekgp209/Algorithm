package BOJ.Silver;

import java.io.*;
import java.util.*;

//1260 DFS와 BFS
class Main {
    
    static int[][] map;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken());   //간선의 개수
        V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            
        }
    }

    public void dfs(int V){
        visited[V] = true;
        System.out.print(V + " ");

        for(int i=1; i<=N+1; i++){
            
        }
    }
}
