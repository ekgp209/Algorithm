package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] arr = new int[max+1];
        for(int i=2; i<=max; i++){
            arr[i] = i;
        }
        //소수 찾기
        for(int i=2; i<Math.sqrt(max); i++){
            if(arr[i] == 0){
                continue;
            }

            for(int j=i+i; j<=max; j=j+i){
                arr[i] = 0;
            }
        }

        for(int i=2)
    }
}
