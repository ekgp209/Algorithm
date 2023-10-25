package BOJ.Platinum;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Node>[] list;
    static PriorityQueue<Integer>[] distance;
    static int n, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());       //도시의 수
        int m = Integer.parseInt(st.nextToken());   //도로의 수
        k = Integer.parseInt(st.nextToken());       //k번째 최단경로

        list = new ArrayList[n + 1];
        distance = new PriorityQueue[n + 1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        
        //각 도로와 소요시간 연결
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());        //도로의 시작점
            int to = Integer.parseInt(st.nextToken());          //도착점점
            int cost = Integer.parseInt(st.nextToken());        //소요시간

            list[from].add(new Node(to, cost));
        }

        distance[1].offer(0);

        Dijkstra(1);

        for(int i=1; i<=n; i++){
            if(distance[i].size() < k){
                System.out.println(-1);
            }else{
                System.out.println(distance[i].peek());
            }
        }
    }

    public static void Dijkstra(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<list[now.idx].size(); i++){
                int nextIdx = list[now.idx].get(i).idx;
                int nextCost = list[now.idx].get(i).cost + now.cost;

                //k번째 최단경로를 구하기 위해 Priority Queue의 사이즈는 k를 초과하면 안됨
                if(distance[nextIdx].size() < k){
                    distance[nextIdx].offer(nextCost);
                    queue.offer(new Node(nextIdx, nextCost));
                }
                //이미 k개의 값이 저장되어있지만 현재의 가중치가 더 작을 경우 갱신해줌
                else if(nextCost < distance[nextIdx].peek()){
                    distance[nextIdx].poll();
                    distance[nextIdx].offer(nextCost);
                    queue.offer(new Node(nextIdx, nextCost));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}
