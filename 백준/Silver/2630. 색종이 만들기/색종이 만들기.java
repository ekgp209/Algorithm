import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //한 변의 길이

        paper = new int[N][N];
        white = 0;
        blue = 0;

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    //partition(x시작점, y시작점, 길이)
    static void partition(int x, int y, int l){
        int start = paper[x][y];
        boolean state = true;

        for(int i=x; i<x+l; i++){
            for(int j=y; j<y+l; j++){
                if (paper[i][j] != start) {
                    state = false;
                }
            }
        }

        if(state){
            if(start == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }  

        partition(x, y, l/2);               //2사분면
        partition(x+(l/2), y, l/2);         //1사분면
        partition(x, y+(l/2), l/2);         //3사분면
        partition(x+(l/2), y+(l/2), l/2);   //4사분면
    }
}