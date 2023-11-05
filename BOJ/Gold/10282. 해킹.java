package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());   //테스트 케이스의 개수

        while(tc --> 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());   //컴퓨터 개수
            int d = Integer.parseInt(st.nextToken());   //의존성 개수
            int c = Integer.parseInt(st.nextToken());   //해킹당한 컴퓨터 번호

            edges = new ArrayList<>();
            distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            for(int i=0; i<=n; i++){
                edges.add(new ArrayList<>());
            }
            
            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   //컴퓨터 a
                int b = Integer.parseInt(st.nextToken());   //컴퓨터 b
                int s = Integer.parseInt(st.nextToken());   //감염시간

                edges.get(b).add(new Edge(a, s));
            }

            distance[c] = 0;
            dijkstra(c);

            int cnt = 0, time = 0;
            for(int i=1; i<=n; i++){
                if(distance[i] != Integer.MAX_VALUE){
                    time = Math.max(time, distance[i]);
                    cnt++;
                }
            }
            System.out.println(cnt + " " + time);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));

        while(!queue.isEmpty()){
            Edge now = queue.poll();

            //이전에 저장되어있는 현재의 노드 값보다 현재 꺼낸 비용이 더 크다면 탐색X
            if(distance[now.node] < now.time)   continue;

            for(int i=0; i<edges.get(now.node).size(); i++){
                Edge tmp = edges.get(now.node).get(i);
                int nextNode = tmp.node;
                int nextTime = tmp.time + now.time;

                if(nextTime < distance[nextNode]){
                    distance[nextNode] = nextTime;
                    queue.add(new Edge(nextNode, nextTime));
                 }
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int node;
        int time;

        public Edge(int node,int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Edge o){
            return this.time - o.time;
        }
    }
}
