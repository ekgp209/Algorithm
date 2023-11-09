package BOJ.Gold;

import java.io.*;
import java.util.*;

class Main {
    static boolean[][] check;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());        //학생 수
        int M = Integer.parseInt(st.nextToken());    //비교횟수

        check = new boolean[N + 1][N + 1];
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            check[a][b] = true;
        }

        floydWarshall();

        int answer = 0;
		for(int i=1; i<=N; i++) {
            int cnt = 0;
			for(int j=1; j<=N; j++) {
                //역방향도 탐색하여 각 노드의 연결되어 있는 노드 카운트
                if(check[i][j] || check[j][i]) {
					cnt++;
				}
			}

            //자신을 제외한 모든 학생과 비교가 가능하다면 키가 몇번째인지 알 수 있음
            if(cnt == N-1)  answer++;
		}
        System.out.println(answer);
    }

    static void floydWarshall(){
        for(int k=1; k<=N; k++){    //중간지점
            for(int i=1; i<=N; i++){    //시작지점
                for(int j=1; j<=N; j++){    //도착지점
                    if(check[i][k] && check[k][j]){
                        check[i][j] = true;
                    }
                }
            }
        }
    }
}
