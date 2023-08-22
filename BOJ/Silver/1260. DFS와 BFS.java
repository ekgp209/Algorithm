package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //정점의 개수
        int M = Integer.parseInt(st.nextToken());   //간선의 개수
        int V = Integer.parseInt(st.nextToken());   //탐색을 시작할 정점의 번호

        list = new ArrayList[N+1];
        visited = new boolean[N+1];

        //인접 리스트 초기화
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>(); 
        }
        
        //인접 리스트에 그래프 데이터 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);     //양쪾에 간선 추가
            list[to].add(from);
        }

        //작은 수부터 방문하기 위해 정렬
        for(int i=1; i<N+1; i++){
            Collections.sort(list[i]);
        }

        DFS(V);

        System.out.println();
        visited = new boolean[N+1];     //BFS를 위해 초기화
        BFS(V);
    }

    public static void DFS(int idx){
        visited[idx] = true;
        System.out.print(idx + " ");

        for(int i : list[idx]){
            if(visited[i] == false){    //방문하지 않은 노드만 탐색
                DFS(i);
            }
        }
    }

    public static void BFS(int idx){
        queue.add(idx);
        visited[idx] = true;

        while(!queue.isEmpty()){
            int nowNow = queue.poll();
            System.out.print(nowNow + " ");

            for(int i : list[nowNow]){
                //현재 노드의 연결 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록
                if(visited[i] == false){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
