import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());    //색상 수

        int[] stone = new int[M];
        int tot_stone = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            stone[i] = Integer.parseInt(st.nextToken());
            tot_stone += stone[i];
        }
        
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());    //랜덤으로 뽑을 수

        double answer = 0.0;
        if(M == 1){     //색상이 1개일 경우
            System.out.println((double)1);
        }else{
            for(int i=0; i<stone.length; i++){
                double tmp = 1.0;
                for(int j=0; j<K; j++){
                    tmp *= (double)(stone[i]-j) / (tot_stone-j);
                }
                answer += tmp;
            }
        }
        System.out.println(answer);
    }
}