package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //사람의 수

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());  //각 사람이 돈을 인출하는데 걸리는 시간
        }

        int tmp = 0;
        for(int i=1; i<N; i++){
            for(int j=0; j<=i; j++){
                if(arr[i] < arr[j]){    //정렬대상 값이 정렬된 배열의 값보다 작은 경우
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int[] sumArr = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                sumArr[i] += arr[j];
            }
            answer += sumArr[i];
        }
        System.out.println(answer);
    }
}
