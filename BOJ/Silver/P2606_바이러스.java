package BOJ.Silver;

import java.io.*;
import java.util.*;

public class P2606_바이러스 {
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int computer = Integer.parseInt(st.nextToken());    //컴퓨터의 수
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());         //컴퓨터 쌍의 수

        //인접 리스트 초기화
        node = new ArrayList[computer + 1];
        for(int i=1; i<computer+1; i++){
            node[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            node[from].add(to);
            node[to].add(from);
        }

        visited = new boolean[computer + 1];
        
        DFS(1);

        System.out.println(cnt);
    }

    public static int DFS(int i){
        visited[i] = true;

        for(int k : node[i]){
            if(visited[k] == false){    //방문하지 않은 노드만 탐색
                DFS(k);
                cnt++;
            }
        }
        return cnt;
    }
}
