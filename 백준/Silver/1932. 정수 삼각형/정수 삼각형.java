import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //아래부터 더한값의 최댓값을 선택하며 올라가기
        for(int i=N-1; i>0; i--){
            for(int j=0; j<i; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}