package BOJ.Bronze;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            int result = A * B / gcd1(A, B);     //두 수의 곱 / 최대 공약수
            System.out.println(result);
        }        
    }

    //최대 공약수 구하기 1
    public static int gcd1(int A, int B){
        while(B != 0){
            int r = A % B;  //A를 B로 나눈 나머지
            A = B;
            B = r;
        }
        return A;
    }
    //최대 공약수 구하기 2 : 재귀함수
    public static int gcd2(int A, int B){
        if(B == 0){
            return A;
        }else{
            return gcd2(B, A % B);
        }
    }
}  
