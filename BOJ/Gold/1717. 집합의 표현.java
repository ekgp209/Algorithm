package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] parent;    //대표 노드 저장 배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());   //연산의 개수

        parent = new int[N + 1];
        for(int i=0; i<=N; i++){
            parent[i] = i;      //대표 노드를 자기 자신으로 초기화
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());    //연산 형태
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(oper == 0){
                union(a, b);
            }else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] = a;      //다른 집합일 경우 대표 노드 변경하여 연결
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);     //parent[a] 값이 가리키는 index 위치로 이동해서 확인
        }
    }
}
