package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10000001];
        for(int i=2; i<arr.length; i++){
            arr[i] = i;
        }

        //소수 찾기
        for(int i=2; i<Math.sqrt(arr.length); i++){
            if(arr[i] == 0){
                continue;
            }

            for(int j=i+i; j<arr.length; j=j+i){
                arr[j] = 0;
            }
        }

        int answer = N;
        while(true){
            if(arr[answer] != 0 && palindrome(arr[answer]) == true){  //소수이면서 팰린드롬인 수 일 경우
                System.out.println(arr[answer]);
                break;
            }else{
                answer++;
            }
        }
    }

    //팰린드롬 수 찾기
    public static boolean palindrome(int target){
        char[] ch = String.valueOf(target).toCharArray();
        int s = 0;
        int e = ch.length - 1;
        while(s < e){
            if(ch[s] != ch[e]){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
