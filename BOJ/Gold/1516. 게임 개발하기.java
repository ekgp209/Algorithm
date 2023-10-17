package BOJ.Gold;

import java.util.*;
import java.io.*;

class Main {
    static int[] inDegree;
    static List<Integer>[] list;
    static int[] buildTime;
    static int[] result;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //건물의 종류 수

        list = new ArrayList[N + 1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();    //초기화
        }

        inDegree = new int[N + 1];      //진입차수 배열
        buildTime = new int[N + 1];     //건물을 짓는데 걸리는 시간
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            //-1이 입력될 때까지 입력 받기
            while(true){
                int num = Integer.parseInt(st.nextToken());

                if(num == -1){
                    break;
                }

                list[num].add(i);
                inDegree[i]++;      //진입차수 값 계산
            }    
        }

        result = new int[N + 1];

        sort();
        for(int i=1; i<=N; i++){
            System.out.println(result[i] + buildTime[i]);   //누적시간 + 자신을 짓는데 걸린 시간
        }
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

            for(int a : list[now]){
                inDegree[a]--;
                result[a] = Math.max(result[a], result[now] + buildTime[now]);  //건물을 짓기 전까지 걸린 누적시간 저장

                if(inDegree[a] == 0){
                    queue.offer(a);
                }
            }
        }
    }
}
