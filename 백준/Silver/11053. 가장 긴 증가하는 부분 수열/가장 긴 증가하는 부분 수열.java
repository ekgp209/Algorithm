import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1;      //모든 DP값은 최소 1
        }

        int max = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    DP[i] = Math.max(DP[i], DP[j]+1);   //이전 원소들 중 가장 큰 DP값 + 1
                }
            }
            max = Math.max(max, DP[i]);
        }
        
        System.out.println(max);
    }
}