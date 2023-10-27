package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};    //상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};
    static int[][] miro;
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());   //가로 크기
        n = Integer.parseInt(st.nextToken());   //세로 크기

        miro = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for(int i=1; i<=n; i++){
            String[] str = br.readLine().split("");
            for(int j=0; j<m; j++){
                miro[i][j+1] = Integer.parseInt(str[j]);
            }
        }

        System.out.println(BFS(1, 1));
    }

    public static int BFS(int y, int x){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(y, x, 0));
        visited[y][x] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            //도착했을 경우
            if(now.x == m && now.y == n){
                return now.cnt;
            }

            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                //다음 방(지점)이 미로 범위 안에 있고, 방문한 적이 없을 경우
                if(1 <= nextX && 1 <= nextY && nextX <= m && nextY <= n){
                    if(!visited[nextY][nextX] && miro[nextY][nextX] == 0){    //빈 방일 경우
                        queue.offer(new Node(nextY, nextX, now.cnt));
                    }else if(!visited[nextY][nextX] && miro[nextY][nextX] == 1){
                       queue.offer(new Node(nextY, nextX, now.cnt + 1));    //벽인 경우 횟수 누적
                    }
                    visited[nextY][nextX] = true;
                }
            }
        }
        return 0;
    }

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int cnt;
        
        public Node(int y, int x, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }
}