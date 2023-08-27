package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {
    static int[] nArr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //정수의 개수
        nArr = new int[N];                    //N개의 정수배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());   //찾아야 할 수의 개수
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            binary(target);
        }
    }

    public static void binary(int target){
        int start = 0;
        int end = nArr.length - 1;

        boolean find = false;

        while(start <= end){
            int mid = (start + end) / 2;
            if(target < nArr[mid]){
                end = mid-1;
            }else if(nArr[mid] < target){
                start = mid+1;
            }else if(nArr[mid] == target){
                find = true;
                break;
            }
        }

        if(find){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
