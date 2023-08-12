package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    public static void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //첫 번째 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());    //DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken());    //비밀번호로 사용할 부분문자열의 길이

        //두 번째 입력
        String DNA = br.readLine();     //임의로 만든 DNA 문자열
        char[] cDNA = DNA.toCharArray();

        //세 번째 입력
        st = new StringTokenizer(br.readLine());
        int[] minDNA = new int[4];
        for(int i=0; i<4; i++){
            minDNA[i] = Integer.parseInt(st.nextToken());   //{A,C,G,T}의 최소 개수
        }
        
        //부분 문자열에 존재하는 DNA 구성
        int[] checkDNA = new int[4];
        for(int i=0; i<4; i++){
            checkDNA[i] = 0;
        }

        //0 ~ P-1까지의 DNA 구성 개수
        for(int i=0; i<P; i++){
            switch(cDNA[i]){
                case 'A':
                    checkDNA[0]++;
                    break;
                case 'C':
                    checkDNA[1]++;
                    break;
                case 'G':
                    checkDNA[2]++;
                    break;
                case 'T':
                    checkDNA[3]++;
                    break;
            }
        }

        int answer = 0;
        for(int i=P; i<S; i++){
            int j = 0;
            switch(cDNA[i]){
                case 'A':
                    checkDNA[0]++;
                    break;
                case 'C':
                    checkDNA[1]++;
                    break;
                case 'G':
                    checkDNA[2]++;
                    break;
                case 'T':
                    checkDNA[3]++;
                    break;
            }

            //비밀번호를 만들 수 있는 경우
            if(checkDNA[0] >= minDNA[0] && checkDNA[1] >= minDNA[1] && checkDNA[2] >= minDNA[2] && checkDNA[3] >= minDNA[3]){
                answer++;
                j =
            }
        }

        
        

        for(int i=P; i<S; i++){
            switch(cDNA[i]){
                case 'A':
                    checkDNA[0]++;
                    break;
                case 'C':
                    checkDNA[1]++;
                    break;
                case 'G':
                    checkDNA[2]++;
                    break;
                case 'T':
                    checkDNA[3]++;
                    break;
            }
        }


        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
