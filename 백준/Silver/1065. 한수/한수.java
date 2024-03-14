import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 99;
        for(int i=100; i<=N; i++){
            int one = i / 100;      //백의 자리 숫자
            int two = (i / 10) % 10;       //십의 자리 숫자
            int three = i % 10;   //일의 자리 숫자
            if(one-two == two-three) {
                answer++;
            }
        }

        if(N < 100){
            System.out.println(N);
        }else{
            System.out.println(answer);
        }
    }
}