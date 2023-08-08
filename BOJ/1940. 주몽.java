package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        

        int N = Integer.parseInt(br.readLine());   //재료의 개수
        int M = Integer.parseInt(br.readLine());   //갑옷을 만드는데 필요한 수

        int[] numArr = new int[N];  //고유한 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);    //오름차순 정렬
        
        int start = 0;
        int end = N-1;
        int cnt = 0;
        //방법1. 투포인터 사용
        while(start < end) {
            int sum = numArr[start] + numArr[end];
            if(sum < M){
                start++;
            }else if(sum > M){
                end--;
            }else if(sum == M){
                cnt++;
                start++;
                end--;
            }
        }

        //방법2. 이중for문 사용
        // for(int i=0; i<N; i++){
        //     for(int j=i+1; j<N; j++){
        //         if(numArr[i] + numArr[j] == M){
        //             cnt++;
        //             break;
        //         }
        //     }
        // }
        System.out.println(cnt);
    }
}
