package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] distance;
    static int N, K;
    static int time;        //소요 시간

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //수빈 위치
        K = Integer.parseInt(st.nextToken());   //동생 위치

        distance = new int[100001];
        for(int i=0; i<distance.length; i++){
            distance[i] = Integer.MAX_VALUE;
        }        

        if(N < K){
            System.out.println(Dijkstra(N));
        }else if(K < N){        //언니가 앞에 위치할 경우 -만 가능
            System.out.println(N - K);
        }else{
            System.out.println(0);
        }
    }

    public static int Dijkstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge now = queue.poll();
            int nowIdx = now.idx;
            int nowCost = now.cost;

            if(distance[nowIdx] < nowCost)  continue;

            //x-1
            if(0 <= nowIdx-1 && nowCost+1 < distance[nowIdx-1]){
                distance[nowIdx-1] = nowCost + 1;   //1초 소요
                queue.add(new Edge(nowIdx-1, distance[nowIdx-1]));
            }
            //x+1
            if(nowIdx+1 <= 100000 && nowCost+1 < distance[nowIdx+1]){
                distance[nowIdx+1] = nowCost + 1;   //1초 소요
                queue.add(new Edge(nowIdx+1, distance[nowIdx+1]));
            }
            //x*2
            if(nowIdx*2 <= 100000 && nowCost < distance[nowIdx*2]){
                distance[nowIdx*2] = nowCost;       //0초 소요
                queue.add(new Edge(nowIdx*2, distance[nowIdx*2]));
            }
        }
        return distance[K];
    }

    public static class Edge implements Comparable<Edge>{
        int idx;
        int cost;

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
