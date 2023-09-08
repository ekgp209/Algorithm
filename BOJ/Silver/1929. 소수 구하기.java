package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());   //M이상
        int N = Integer.parseInt(st.nextToken());   //N이하

        //1. N까지의 배열 생성
        int[] arr = new int[N+1];
        for(int i=2; i<=N; i++){
            arr[i] = i;
        }

        //2. 2부터 배수 삭제
        for(int i=2; i<=Math.sqrt(N); i++){     //제곱근까지만 비교 -> 이후는 어짜피 배수임
            //배수로 처리한 상태 (0)
            if(arr[i] == 0){
                continue;
            }

            for(int j=i+i; j<=N; j=j+i){
                arr[j] = 0;
            }
        }

        //3. 삭제되지 않은 수 출력
        for(int i=M; i<=N; i++){
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }
}