package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<ArrayList<Edge>> edges;
    static int[] dist;
    static int N, M, W;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());  //테스트케이스 수

        for(int i=0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());       //지점 수
            M = Integer.parseInt(st.nextToken());       //도로 수
            W = Integer.parseInt(st.nextToken());       //웜홀 수

            edges = new ArrayList<>();
            dist = new int[N + 1];
            for(int j=0; j<=N; j++){
                edges.add(new ArrayList<>());
            }

            for(int j=0; j<M+W; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());        //시작지점
                int e = Integer.parseInt(st.nextToken());        //도착지점
                int t = Integer.parseInt(st.nextToken());        //이동시간

                if(j < M){      //도로 -> 양방향
                    edges.get(s).add(new Edge(e, t));
                    edges.get(e).add(new Edge(s, t));
                }else{          //웜홀 -> 단방향
                    edges.get(s).add(new Edge(e, -t));
                }
            }

            if(BellmanFord()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean BellmanFord(){
        boolean update = false;

        //최단거리 초기화(N-1번) + 최종확인(1번) = N번
        for(int i=1; i<=N; i++){
            update = false;

            for(int j=1; j<=N; j++){
                for(Edge edge : edges.get(j)){
                    if(dist[j] + edge.time < dist[edge.node]){
                        dist[edge.node] = dist[j] + edge.time;
                        update = true;
                    }
                }
            }

            //진행 중에 최단거리가 한번이라도 갱신되지 않을 경우 반복문 종료
            if(!update){
                break;
            }
        }
        return update;
    }

    public static class Edge{
        int node;
        int time;

        public Edge(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
}
