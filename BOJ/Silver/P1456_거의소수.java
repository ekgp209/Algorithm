package BOJ.Silver;

import java.io.*;
import java.util.*;

public class P1456_거의소수{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());   //A이상
        long B = Long.parseLong(st.nextToken());   //B이하

        //1. B까지의 배열 생성
        long[] arr = new long[(int) (B+1)];
        for(int i=2; i<=B; i++){
            arr[i] = i;
        }

        //2. 2부터 배수 삭제
        int cnt = 0;
        for(int i=2; i<=Math.sqrt(B); i++){     //제곱근까지만 비교
            if(arr[i] == 0){
                continue;
            }

            for(int j=i+i; j<=B; j=j+i){
                arr[j] = 0;               
            }
        }

        //3. 거의 소수 찾기
        for(int i=2; i<=B; i++){
            if(arr[i] != 0){
                for(int j=2; j<=Math.sqrt(B); j++){
                    if(A <= Math.pow(i, j) && Math.pow(i, j) <= B){
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}