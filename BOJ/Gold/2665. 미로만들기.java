package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};    //상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};
    static int[][] miro;
    static int[][] distance;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   //한 줄의 방 수

        miro = new int[n][n];
        distance = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j=0; j<n; j++){
                miro[i][j] = Integer.parseInt(str[j]);
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        BFS(0, 0);  //{0, 0}에서 시작
        System.out.println(distance[n-1][n-1]);
    }

    public static void BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        distance[x][y] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                //다음 방(지점)이 미로 범위 안에 있고, 방문한 적이 없을 경우
                if(0 <= nextX && 0 <= nextY && nextX < n && nextY < n && distance[now.x][now.y] < distance[nextX][nextY]){
                    if(miro[nextX][nextY] == 1){    //흰방일 경우
                        distance[nextX][nextY] = distance[now.x][now.y];
                    }else{
                        distance[nextX][nextY] = distance[now.x][now.y] + 1;    //검정방인 경우 횟수 누적
                    }
                    queue.offer(new Node(nextX, nextY));
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
