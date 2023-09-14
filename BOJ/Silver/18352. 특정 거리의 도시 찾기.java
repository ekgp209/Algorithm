package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] node;
    static int[] visited;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //도시의 개수
        int M = Integer.parseInt(st.nextToken());   //도로의 개수
        int K = Integer.parseInt(st.nextToken());   //거리 정보
        int X = Integer.parseInt(st.nextToken());   //출발 도시의 번호

        node = new ArrayList[N+1];
        answer = new ArrayList<>();
        //arraylist 초기화
        for(int i=1; i<N+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());   //출발 노드
            int to = Integer.parseInt(st.nextToken());   //도착 노드
            node[from].add(to);
        }

        //방문 배열 초기화
        visited = new int[N+1];
        for(int i=0; i<N+1; i++){
            visited[i] = -1;
        }

        BFS(X);

        for(int i=0; i<N+1; i++){
            if(visited[i] == K){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int i : answer){
                System.out.println(i);
            }
        }
    }

    public static void BFS(int X){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(X);   //출발 노드
        visited[X]++;

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i : node[nowNode]){
                //현재 노드의 연결 중 미방문 노드를 큐에 삽입하고 방문 배열에 거리 누적
                if(visited[i] == -1){
                    visited[i] = visited[nowNode] + 1;    //이전 노드의 방문거리+1
                    queue.add(i);
                }
            }
        }
    }
}
