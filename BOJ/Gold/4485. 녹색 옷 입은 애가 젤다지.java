package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static int[] dx = {0, 1, 0, -1};        //상, 우, 하, 좌
    static int[] dy = {1, 0, -1, 0};
    static int[][] board;
    static int[][] distance;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());       //동굴의 크기

            if(N == 0){
                break;
            }

            board = new int[N][N];
            distance = new int[N][N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }

            BFS(0, 0, board[0][0]);

            System.out.println("Problem " + idx + ": " + distance[N-1][N-1]);
            idx++;
            
        }
    }

    public static void BFS(int x, int y, int cost){
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(x, y, cost));
        distance[x][y] = cost;

        while(!queue.isEmpty()){
            Edge now = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                //다음 경로가 범위 안에 있고, 가중치가 더 작은 경우
                if(0 <= nextX && 0 <= nextY && nextX < N && nextY < N && distance[now.x][now.y] + board[nextX][nextY] < distance[nextX][nextY]){
                    distance[nextX][nextY] = distance[now.x][now.y] + board[nextX][nextY];
                    queue.offer(new Edge(nextX, nextY, distance[nextX][nextY]));
                }
            }
        }
    }

    public static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost){
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
}
