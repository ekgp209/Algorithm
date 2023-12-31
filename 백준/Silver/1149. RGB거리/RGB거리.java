import java.io.*;
import java.util.*;

public class Main {
    static int[][] house;
    static int[][] DP;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    //집의 수
        house = new int[N][3];      //각 색상 별 칠하는 비용
        DP = new int[N][3];         //빨, 초, 파의 각 최소 비용

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //DP의 첫번째 값은 색상 비용의 첫번째 값으로 초기화
        DP[0][0] = house[0][0];
        DP[0][1] = house[0][1];
        DP[0][2] = house[0][2];

        System.out.println(Math.min(paintCost(N-1, 0), Math.min(paintCost(N-1, 1), paintCost(N-1, 2))));
    }

    static int paintCost(int N, int color){
        //아직 탐색하지 않은 배열이라면
        if(DP[N][color] == 0){

            //color색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더하여 DP에 저장
            if(color == 0){         //빨강
                DP[N][0] = Math.min(paintCost(N - 1, 1), paintCost(N - 1, 2)) + house[N][0];
            }else if(color == 1){   //초록
                DP[N][1] = Math.min(paintCost(N - 1, 0), paintCost(N - 1, 2)) + house[N][1];
            }else if(color == 2){   //파랑
                DP[N][2] = Math.min(paintCost(N - 1, 0), paintCost(N - 1, 1)) + house[N][2];
            }
        }

        return DP[N][color];
    }
}