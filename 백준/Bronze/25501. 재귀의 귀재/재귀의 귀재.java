import java.io.*;

public class Main{
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int T = Integer.parseInt(br.readLine());

        while(T --> 0){
            String str = br.readLine();

            System.out.println(isPalindrome(str) + " " + cnt);
        }
    }

    static int isPalindrome(String s){
        cnt = 1;
        return recursion(s, 0, s.length()-1);
    }

    static int recursion(String s, int l, int r){
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r))   return 0;
        else{
            cnt++;
            return recursion(s, l+1, r-1);
        }
    }
}