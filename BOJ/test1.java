package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1 {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //수의 개수
        int[] arr = new int[N];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        //기수 정렬
        int[] tempArr = new int[10];     //자리수에 따라 임시 정렬하는 배열
        int a = 1;                       //자릿수
        for(int i=0; i<N; i++){
            tempArr[(arr[i]/a) % 10]
        }


    }

    public static void main(String[] args) throws IOException{
        solution();
    }
}
