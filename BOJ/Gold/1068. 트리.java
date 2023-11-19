package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int removeN;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        visited = new boolean[N];
        for(int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());

            if(n == -1){
                root = i;     //부모노드
            }else{
                tree[n].add(i);
                tree[i].add(n);
            }
        }

        removeN = Integer.parseInt(br.readLine());
        if(removeN == root){
            System.out.println(0);
        }else{
            DFS(root);
            System.out.println(answer);
        }
    }

    static void DFS(int n){
        visited[n] = true;

        boolean leaf = false;   //자식노드 유무 판별
        for(int i : tree[n]){
            if(!visited[i] && i != removeN){
                leaf = true;
                DFS(i);
            }
        }

        if(!leaf){      //자식노드가 없다면
            answer++;
        }
    }
}
