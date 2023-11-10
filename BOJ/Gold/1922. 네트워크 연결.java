package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static PriorityQueue<Edge> queue;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());       //컴퓨터의 수
        int M = Integer.parseInt(br.readLine());       //선의 수

        queue = new PriorityQueue<>();
        //유니온 파인드 배열 초기화
        parent = new int[N + 1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            queue.add(new Edge(s, e, w));
        }

        int cnt = 0;
        int result = 0;
        while(cnt < N-1){
            Edge now = queue.poll();
            //같은 부모가 아니라면 연결
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.cost;
                cnt++;
            }
        }
        System.out.println(result);
    }

    //union: 대표 노드끼리 연결하는 함수
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;      //다른 집합일 경우 대표 노드 변경하여 연결
        }
    }

    //find: 대표 노드가 같은지 확인(싸이클 확인)
    static int find(int a){
        if(a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);     //parent[a]가 값이 가리키는 index 위치로 이동해서 확인
    }

    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}
