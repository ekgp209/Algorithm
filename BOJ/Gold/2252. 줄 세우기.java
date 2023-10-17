package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] list;
    static int[] inDegree;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //학생 수
        int M = Integer.parseInt(st.nextToken());   //키를 비교한 횟수
        
        list = new ArrayList[N + 1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];    //진입차수 저장 배열
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            inDegree[B]++;      //진입차수 값 계산
        }

        sort();
    }

    //위상 정렬 수행
    public static void sort(){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            //진입차수가 0인 노드를 선택
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(queue.size() != 0){
            int now = queue.poll();
            System.out.print(now + " ");

            for(int a : list[now]){
                inDegree[a]--;

                if(inDegree[a] == 0){
                    queue.offer(a);
                }
            }
        }
    }
}
