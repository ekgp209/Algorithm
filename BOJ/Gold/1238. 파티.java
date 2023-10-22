package BOJ.Gold;

import java.util.*;
import java.io.*;

class Main {
    static int[] distance;
    static ArrayList<Edge>[] edgeList;
    static int from, to;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //학생 수
        int M = Integer.parseInt(st.nextToken());   //도로의 수
        int X = Integer.parseInt(st.nextToken());   //파티를 벌일 마을 번호

        edgeList = new ArrayList[N + 1];
        for(int i=1; i<=N; i++){
            edgeList[i] = new ArrayList<>();
        }
        
        //각 도로와 소요시간 연결
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());        //도로의 시작점
            to = Integer.parseInt(st.nextToken());          //끝점
            int cost = Integer.parseInt(st.nextToken());    //필요한 소요시간

            edgeList[from].add(new Edge(to, cost));
        }

        int[] answer = new int[N + 1];
        //각 마을에서 X번 마을까지의 최단거리 계산
        for(int i=1; i<=N; i++){
            distance = new int[N + 1];
            for(int j=1; j<distance.length; j++){
                distance[j] = Integer.MAX_VALUE;    //최소비용 배열 무한값으로 초기화
            }

            distance[i] = 0;
            Dijkstra(i);
            answer[i] += distance[X];
        }
        
        //X마을에서 각 마을까지의 최단거리 계산
        distance = new int[N + 1];
        for(int i=1; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;    //최소비용 배열 무한값으로 초기화
        }
        distance[X] = 0;
        Dijkstra(X);

        for(int i=0; i<distance.length; i++){
            answer[i] += distance[i];
        }

        System.out.println(Arrays.stream(answer).max().getAsInt());   //최댓값 찾기
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
