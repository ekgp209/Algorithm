package BOJ;

import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   //수열의 개수
        int[] arr = new int[n]; //수열 배열
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();   //*바로 print하지 않는 이유: 답이 NO가 될 수도 있으므로
        int num = 1;
        boolean result = true;
        for(int i=0; i<arr.length; i++){
            //현재 수열 값 >= push값
            if(arr[i] >= num){
                while(arr[i] >= num){
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            //현재 수열 값 < pop값
            else{
                if(stack.pop() > arr[i]){
                    System.out.println("NO");
                    result = false;
                    break;
                }else{
                    sb.append("-\n");
                }
            }
        }
        
        if(result){
            System.out.println(sb.toString());
        }
    }
}