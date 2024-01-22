import java.io.*;

public class Main{
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         * 1. n-1개의 원판을 나머지 기둥으로 전부 옮긴다.
         * 2. n번 원판을 목적지 기둥으로 옮긴다.
         * 3. 나머지 n-1개의 원판을 목적지 기둥으로 옮긴다.
         */
        
        int N = Integer.parseInt(br.readLine());

        System.out.println((int)Math.pow(2, N) - 1);    //옮긴횟수
        hanoi(N, 1, 2, 3);

        bw.flush();
        bw.close();
        br.close();
    }

    //hanoi(n(원반수), from(출발지), other(경유지), to(목적지))
    static void hanoi(int n, int from, int other, int to) throws IOException{
        if(n == 1) {
            bw.write(from + " " + to + "\n");
            return;
        }

        hanoi(n-1, from, to, other);        //1. 1번기둥의 n-1개를 3번을 경유해 2번으로 이동
        
        bw.write(from + " " + to + "\n");   //2. n번 원판을 3번으로 이동
        
        hanoi(n-1, other, from, to);    //3. 2번기둥의 n-1개를 1번을 경유해 3번으로 이동
    }
}