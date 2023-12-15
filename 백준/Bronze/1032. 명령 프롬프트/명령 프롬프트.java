import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++){
            str[i] = br.readLine();
        }

        String answer = "";
        for(int i=0; i<str[0].length(); i++){
            char tmp = str[0].charAt(i);
            for(int j=1; j<N; j++){    
                if(tmp != str[j].charAt(i)){
                    answer += "?";
                    break;
                }

                if(j == N-1){
                    answer += tmp;
                }    
            }
        }
        if(N == 1){
            System.out.println(str[0]);
        }else{
            System.out.println(answer);
        }
    }
}