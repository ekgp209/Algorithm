package Lv3;

import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<Edge> queue;
    static int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        queue = new PriorityQueue<>();
        parent = new int[n + 1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<costs.length; i++){
            int s = costs[i][0];
            int e = costs[i][1];
            int w = costs[i][2];

            queue.add(new Edge(s, e, w));
        }

        int cnt = 0;
        //에지의 개수가 n-1이 되면 종료
        while(cnt < n-1){
            Edge now = queue.poll();

            if(find(now.s) != find(now.e)){
                uinon(now.s, now.e);
                answer += now.w;
                cnt++;
            }
        }

        return answer;
    }

    static void uinon(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;      //다른 집합인 경우 대표 노드 변경하여 연결
        }
    }

    static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return this.w - o.w;
        }
    }
}
