package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] distance;
    static ArrayList<Edge>[] edgeList;
    static int K;      //시작점

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   //정점의 개수
        int E = Integer.parseInt(st.nextToken());   //간선의 개수

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());       //시작점 번호

        edgeList = new ArrayList[V + 1];
        distance = new int[V + 1];
        for(int i=1; i<=V; i++){
            distance[i] = Integer.MAX_VALUE;
            edgeList[i] = new ArrayList<>();
        }

        //각 정점과 가중치 연결
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());    //시작점
            int to = Integer.parseInt(st.nextToken());      //도착점
            int cost = Integer.parseInt(st.nextToken());    //가중치

            edgeList[from].add(new Edge(to, cost));
        }

        Dijkstra(K);

        for(int i=1; i<=V; i++){
            if(i == K){     //시작점은 0 출력
                System.out.println(0);
                continue;
            }

            if(distance[i] < Integer.MAX_VALUE){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");      //경로가 존재하지 않는 경우
            }
        }
        
    }

    public static void Dijkstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            int nowIdx = now.idx;
            int nowCost = now.cost;

            //이전에 저장되어있는 현재의 노드 값보다 현재 꺼낸 비용이 더 크다면 탐색X
            if(distance[nowIdx] < nowCost)  continue;

            for(int i=0; i<edgeList[nowIdx].size(); i++){
                 Edge tmp = edgeList[nowIdx].get(i);
                 int nextIdx = tmp.idx;
                 int nextCost = tmp.cost + nowCost;

                 if(nextCost < distance[nextIdx]){
                    distance[nextIdx] = nextCost;
                    queue.add(new Edge(nextIdx, nextCost));
                 }
            }
        }
    }

    public static class Edge implements Comparable<Edge>{
        int idx;    //가리키는 노드
        int cost;   //엣지의 가중치

        public Edge(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return cost - o.cost;
        }
    }
}
