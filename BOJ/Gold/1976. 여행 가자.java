package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //도시의 수
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());   //여행 계획에 속한 도시들의 수

        parent = new int[N + 1];
        for(int i=0; i<=N; i++){
            parent[i] = i;      //대표 노드를 자기 자신으로 초기화
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){     //연결되었다면
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] route = new int[M + 1];
        for(int i=1; i<=M; i++){
            route[i] = Integer.parseInt(st.nextToken());    //여행 계획 저장
        }

        //도시들이 1개의 대표 도시로 연결되어있는지 확인
        for(int i=1; i<M; i++){
            if(find(route[i]) != find(route[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }
}
