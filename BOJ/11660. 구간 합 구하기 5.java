package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());  
          
        int N = Integer.parseInt(st.nextToken());    //표의 크기
        int M = Integer.parseInt(st.nextToken());    //합을 구해야 하는 횟수

        int[][] board = new int[N+1][N+1];
        //표의 값 입력받기
        board[0][0] = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int a = Integer.parseInt(st.nextToken());
                board[i][j] = board[i][j-1] + board[i-1][j] - board[i-1][j-1] + a;
            }
        }

        int answer = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //구간 합 공식
            answer = board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1];

            System.out.println(answer);      
        }
    }
}
