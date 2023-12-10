import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] D = new int[30][30];
        for(int i=0; i<30; i++){
            D[i][i] = 1;
            D[i][0] = 1; 
        }
        for(int i=2; i<30; i++){
            for(int j=1; j<30; j++){
                D[i][j] = D[i-1][j] + D[i-1][j-1];
            }
        }
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());    //서쪽
            int M = Integer.parseInt(st.nextToken());    //동쪽

            //M개중 N개를 뽑는 경우(mCn)
            System.out.println(D[M][N]);
        }
    }
}