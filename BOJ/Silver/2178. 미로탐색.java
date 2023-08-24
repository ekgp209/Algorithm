package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] miro;
    static int N, M;
    static boolean[][] visited;
    static int[] moveX = {0, 0, -1, 1};     //x방향배열_상하
    static int[] moveY = {1, -1, 0, 0};     //y방향배열_좌우

    public static void main(String[] args) throws IOException{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   //row
        M = Integer.parseInt(st.nextToken());   //column

        //배열에 데이터 저장
        miro = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<M; j++){
                miro[i][j] = s.charAt(j) - '0';
            } 
        }

        visited = new boolean[N][M];
        BFS(0, 0);
        System.out.println(miro[N-1][M-1]);
    }

    public static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++){
                int nextX = now[0] + moveX[i];
                int nextY = now[1] + moveY[i];

                //좌표 유효성 검사(미로의 범위가 벗어난 경우)
                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M){
                    continue;
                }
                if(visited[nextX][nextY] == true || miro[nextX][nextY] == 0){
                    continue;
                }

                queue.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = true;
                miro[nextX][nextY] = miro[now[0]][now[1]] + 1;      //depth + 1
            }
        }
    }
}
