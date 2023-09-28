package Lv3;

import java.util.*;

class Solution {
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int[] answer;

    public int solution(int n, int[][] edge) {
        node = new ArrayList[n+1];
        answer = new int[n+1];
        visited = new boolean[n+1];

        //arrayList 초기화
        for(int i=1; i<n+1; i++){
            node[i] = new ArrayList<>();
        }
        //간선 연결
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            node[from].add(to);     //양방향 간선이므로
            node[to].add(from);
        }

        BFS(1);

        int max = Arrays.stream(answer).max().getAsInt();   //최댓값 찾기

        int count = 0;
        for(int i=1; i<n+1; i++){
            if(answer[i] == max){
                count++;
            }
        }

        return count;
    }

    public static void BFS(int x){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(x);
        visited[x] = true;

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i : node[nowNode]){
                if(!visited[i]){
                    visited[i] = true;
                    answer[i] = answer[nowNode]+1;  //이전 도시 방문 배열값 + 1
                    queue.add(i);
                }
            }
        }
    }
}