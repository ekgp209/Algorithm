package BOJ.Bronze;

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int score[] = new int[n];
        for(int i=0; i<n; i++){
            score[i] = scan.nextInt();
        }
        
        long sum = 0;
        long max = 0;
        for(int i=0; i<n; i++){
            if(score[i] > max){
                max = score[i];
            }
            sum += score[i];
        }
        //평균값: 총합 * 100 / 최고점수 / 과목 수
        System.out.println(sum * 100.0 / max / n);
    }
}
