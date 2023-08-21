package BOJ.Silver;

import java.io.*;
import java.util.*;

//1260 DFS와 BFS
class Main {
    
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //정점의 개수
        M = Integer.parseInt(st.nextToken());   //간선의 개수
        V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

        arr = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();         //초기화  
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int
        }
    }

    public void DFS(int v){
        visited[v] = true;
        System.out.print(v + " ");

        for(int i : arr[v]){
            if(visited[i] == false){    //방문하지 않은 노드만 탐색
                DFS(i);
            }
        }
    }
}
