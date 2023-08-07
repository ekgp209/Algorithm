package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start = 0, end = 0;     //투포인터 설정
        int sum = 0, cnt = 0;
        while(start <= N) {
            //합이 N과 일치할 때
            if(sum == N) {
                cnt++;
            }

            if(sum < N) {
                end++;
                sum += end;
            }else if(N <= sum) {
                start++;
                sum -= start;
            }
        }
        System.out.println(cnt);
    }
}
