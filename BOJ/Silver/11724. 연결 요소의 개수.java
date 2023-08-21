package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //노드의 개수
        int M = Integer.parseInt(st.nextToken());   //에지의 개수
        list = new ArrayList[N+1];       //인접 리스트 저장 배열
        visited = new boolean[N+1];     //방문 기록 저장 배열

        //인접 리스트 초기화
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<Integer>();
        }

        //인접 리스트에 그래프 데이터 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);     //양쪽에 간선 추가
            list[to].add(from);            
        }

        int cnt = 0;
        for(int i=1; i<list.length; i++){
            if(visited[i] == false){    //방문한 적 없는 노드인 경우
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void DFS(int v){
        if(visited[v] == true){
            return;
        }

        visited[v] = true;
        for(int i : list[v]){
            if(visited[i] == false){    //연결 노드 중 방문하지 않았던 노드만 탐색
                DFS(i);
            }
        }

    }
}
