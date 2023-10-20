package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] distance;              //최소비용 저장 배열
    static ArrayList<Edge>[] edgeList;    //간선의 정보를 담을 배열
    static boolean[] visited;           //방문확인 배열
    static int from, to;                //출발,도착 도시번호
    static int cost;                    //버스 비용

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //도시의 개수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());   //버스의 개수

        edgeList = new ArrayList[N + 1];
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;    //최소비용 배열 무한값으로 초기화
        }
        for(int i=1; i<=N; i++){
            edgeList[i] = new ArrayList<>();
        }
        
        //각 도시와 버스 비용 연결
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());    //출발도시 번호
            to = Integer.parseInt(st.nextToken());      //도착도시 번호
            cost = Integer.parseInt(st.nextToken());    //버스 비용

            edgeList[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());   //출발점 도시번호
        int end = Integer.parseInt(st.nextToken());     //도착점 도시번호

        distance[start] = 0;    //시작점 비용 0으로 시작

        Dijkstra(start);

        System.out.println(distance[end]);
    }

    public static void Dijkstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            int nowIdx = now.idx;
            int nowCost = now.cost;

            if(visited[nowIdx])  continue;

            visited[nowIdx] = true;

            for(int i=0; i<edgeList[nowIdx].size(); i++){
                Edge tmp = edgeList[nowIdx].get(i);
                int nextIdx = tmp.idx;
                int nextCost = tmp.cost + nowCost;

                //이전에 저장되어있는 해당 노드의 최소비용보다, 다른 노드와의 최소비용이 더 작은경우 값 갱신
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
