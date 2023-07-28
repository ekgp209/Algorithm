package BOJ.Silver;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        int N = scan.nextInt();     //수의 개수
        int M = scan.nextInt();     //합을 구해야 하는 횟수

        int[] S = new int[N+1];
        S[0] = 0;
        for(int i=1; i<=N; i++){
            S[i] = S[i-1] + scan.nextInt();     //배열을 입력받을 때 누적합으로 저장
        }

        for(int i=0; i<M; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            //구간 합 공식 (a ~ b까지 구간 합)
            System.out.println(S[b] - S[a-1]);      
        }
    }
}