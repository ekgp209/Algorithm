package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2343_기타레슨 {
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //레슨 개수
        int M = Integer.parseInt(st.nextToken());   //블루레이 개수

        arr = new int[N];
        int start = 0;      //시작 인덱스
        int end = 0;        //종료 인덱스
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(start < arr[i]){
                start = arr[i];     //레슨 중 최댓값
            }
            end += arr[i];  //모든 레슨의 총 합
        }


    }

    public static void binary(int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            int sum = 0;    //레슨의 합
            int cnt = 0;    //블루레이의 수

            for(int i : arr) {
                if(sum + i > mid){
                    cnt++;
                    sum = 0;
                }
                sum += i;
            }
        }
    }
}

