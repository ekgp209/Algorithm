package BOJ.Silver;

import java.util.*;
import java.io.*;

class Main {
    static int[][] node;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, cnt;
    static int answer;  //총 단지수

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //지도의 크기

        node = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String[] str = st.nextToken().split("");
            for(int j=0; j<N; j++){
                node[i][j] = Integer.parseInt(str[j]);
            }
        }

        ArrayList<Integer> house = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(node[i][j] == 1 && !visited[i][j]){
                    cnt = 1;

                    DFS(i, j);
                    answer++;
                    house.add(cnt);
                }
            }
        }

        Collections.sort(house);

        System.out.println(answer);
        for(int i : house){
            System.out.println(i);
        }
    }

    public static void DFS(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(0 <= newX && 0 <= newY & newX < N && newY < N){      //좌표 범위를 벗어나지 않고
                if(node[newX][newY] == 1 && !visited[newX][newY]){  //방문하지 않은 인접배열이라면
                    DFS(newX, newY);
                    cnt++;
                }
            }
        }
    }
}