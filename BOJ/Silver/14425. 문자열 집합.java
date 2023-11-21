package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //문자열 개수
        int M = Integer.parseInt(st.nextToken());   //입력 문자열 수

        String[] S = new String[N];
        for(int i=0; i<N; i++){
            S[i] = br.readLine();
        }

        int answer = 0;
        for(int i=0; i<M; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                if(str.equals(S[j]))    answer++;
                continue;
            }
        }

        System.out.println(answer);
    }
}
