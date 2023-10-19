package BOJ.Silver;

import java.io.*;
import java.util.*;

//Dijkstra 알고리즘 사용
class Main {
    static int[] distance;  //최단경로 저장 배열
    static ArrayList<Edge>[] edgeList; //간선의 정보 담을 배열
    static boolean[] visited;   //방문확인 배열
    static int X;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //도시의 개수
        int M = Integer.parseInt(st.nextToken());   //도로의 개수
        int K = Integer.parseInt(st.nextToken());   //거리 정보
        X = Integer.parseInt(st.nextToken());   //출발 도시의 번호

        edgeList = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;    //최단경로 배열 무한으로 초기화
        }
        for(int i=1; i<=N; i++){
            edgeList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());   //출발 노드
            int to = Integer.parseInt(st.nextToken());   //도착 노드

            edgeList[from].add(new Edge(to, 1));
        }
        //출발 도시
        distance[X] = 0;

        Dijkstra();

        int answer = 0;
        for(int i=1; i<=N; i++){
            if(distance[i] == K){
                System.out.println(i);
                answer++;
            }
        }

        if(answer == 0) System.out.println(-1);
    }

    public static void Dijkstra(){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(X, 0));      //시작점 X로 설정

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            int nowV = now.vertex;
            int nowC = now.cost;

            if(visited[nowV])  continue;   //방문한 적이 있다면 다시 큐에 넣지 않음

            visited[nowV] = true;
            //현재 도시와 연결되어 있는 도시들 탐색
            for(int i=0; i<edgeList[nowV].size(); i++){
                Edge tmp = edgeList[nowV].get(i);
                int nextV = tmp.vertex;
                int nextC = tmp.cost + nowC;
                
                if(distance[nextV] > nextC){
                    distance[nextV] = nextC;
                    queue.add(new Edge(nextV, nextC));
                }
            }
        }
    }

    //도착지점과, 도착지점으로 가는 가중치를 의미하는 클래스 정의
    public static class Edge implements Comparable<Edge>{
        int vertex;     //가리키는 노드
        int cost;       //에지의 가중치

        public Edge(int vertex, int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return cost - o.cost;
        }
    }
}
