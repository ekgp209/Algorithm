package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Edge> edges;
    static long[] distance;
    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());       //도시의 수
        M = Integer.parseInt(st.nextToken());       //버스 노선의 수

        edges = new ArrayList<>();
        distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());        //시작도시
            int to = Integer.parseInt(st.nextToken());          //도착도시
            int cost = Integer.parseInt(st.nextToken());        //소요시간

            edges.add(new Edge(from, to, cost));
        }

        BellmanFord(N, M);
    }

    public static void BellmanFord(int start, int end){
        distance[1] = 0;
        
        //모든 엣지를 확인해 가중치 배열 업데이트
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                Edge now = edges.get(j);

                if(distance[now.s] != Long.MAX_VALUE && distance[now.s] + now.time < distance[now.e]){
                    distance[now.e] = distance[now.s] + now.time;
                }
            }
        }

        //음수 사이클 유무 확인
        for(int i=0; i<M; i++){
            Edge now = edges.get(i);

            if(distance[now.s] != Long.MAX_VALUE && distance[now.s] + now.time < distance[now.e]){
                System.out.println("-1");
                return;
            }
        }

        for(int i=2; i<=N; i++){
            if(distance[i] == Long.MAX_VALUE)
                System.out.println("-1");
            else
                System.out.println(distance[i]);
        }
    }

    public static class Edge{
        int s;
        int e;
        int time;

        public Edge(int s, int e, int time){
            this.s = s;
            this.e = e;
            this.time = time;
        }
    }
}
