package BOJ.Gold;

import java.io.*;
import java.util.*;

public class P1043_거짓말 {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //사람의 수
        int M = Integer.parseInt(st.nextToken());   //파티의 수

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());   //진실을 아는 사람의 수
        for(int i=0; i<T; i++){

        }
        int Tn = Integer.parseInt(st.nextToken());  //

        parent = new int[N + 1];
        for(int i=0; i<=N; i++){
            parent[i] = i;      //대표 노드를 자기 자신으로 초기화
        }

        

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
