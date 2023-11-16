package BOJ.Gold;

import java.util.*;
import java.io.*;

class Main {
    static PriorityQueue<Edge> queue;
    static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       //컴퓨터 수
        
        queue = new PriorityQueue<>();
        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }

        int sum = 0;        //랜선의 총 합 저장
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();

            for(int j=0; j<N; j++){
                int len = 0;
                //랜선 정보 저장
                if('a' <= tmp[j] && tmp[j] <= 'z'){     //소문자인 경우
                    len = tmp[j] - 'a' + 1;
                }else if('A' <= tmp[j] && tmp[j] <= 'Z'){   //대문자인 경우
                    len = tmp[j] - 'A' + 27;
                }

                //자기 자신이 아니고, 랜선이 연결되어 있을 때 큐에 저장
                if(i != j && len != 0){
                    queue.add(new Edge(i, j, len));
                }
                sum += len;
            }
        }

        int cnt = 0;
        int result = 0;
        while(!queue.isEmpty()){
            Edge now = queue.poll();
            //같은 부모가 아니라면 연결
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.cost;
                cnt++;
            }
        }

        if(cnt == N-1){
            System.out.println(sum - result);
        }else{
            System.out.println(-1);
        }
    }

    //union: 대표 노드끼리 연결하는 함수
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

    //find: 대표노드가 같은지 확인(싸이클 확인)
    static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);     //parent[a]가 값이 가리키는 index 위치로 이동해서 확인
        }
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
