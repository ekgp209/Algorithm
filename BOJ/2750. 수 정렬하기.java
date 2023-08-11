package BOJ;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //수의 개수
        int[] numArr = new int[N];
        for(int i=0; i<N; i++){
            numArr[i] = sc.nextInt();
        }

        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-1; j++){
                //뒤의 수가 더 작은 경우
                if(numArr[j] > numArr[j+1]){
                    int tmp = numArr[j+1];
                    numArr[j+1] = numArr[j];
                    numArr[j] = tmp;
                }
            }
        }
        for(int i=0; i<numArr.length; i++){
            System.out.println(numArr[i]);
        }
    }
}
