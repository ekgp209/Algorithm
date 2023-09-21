package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] node;
    static int[] answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //컴퓨터 개수
        int M = Integer.parseInt(st.nextToken());
        
        node = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1; i<N+1; i++){
            node[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            node[from].add(to);
        }

        //방문 배열 초기화 및 모든 노드 BFS 실행
        for(int i=1; i<N+1; i++){
            visited = new boolean[N+1];
            BFS(i);
        }

        int max = Arrays.stream(answer).max().getAsInt();   //최댓값 찾기

        for(int i=1; i<N+1; i++){
            if(answer[i] == max){
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS(int X){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(X);   //시작 노드
        visited[X] = true;

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i : node[nowNode]){
                //현재 노드의 연결 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록
                if(!visited[i]){
                    visited[i] = true;
                    answer[i]++;        //배열값 증가
                    queue.add(i);
                }
            }
        }
    }
}
