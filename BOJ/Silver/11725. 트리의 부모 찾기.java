package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //노드의 개수

        tree = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        answer = new int[N + 1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            tree[s].add(e);
            tree[e].add(s);
        }

        DFS(1);

        for(int i=2; i<=N; i++){
            System.out.println(answer[i]);
        }
    }

    static void DFS(int n){
        visited[n] = true;

        for(int i : tree[n]){
            if(!visited[i]){
                answer[i] = n;
                DFS(i);
            }
        }
    }
}
