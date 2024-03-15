import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //명령어 수

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();

            if(s.contains("push")){
                String[] pustStr = s.split(" ");
                stack.push(Integer.parseInt(pustStr[1]));
            }else if(s.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.pop());
                }
            }else if(s.equals("size")){
                System.out.println(stack.size());
            }else if(s.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else{
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.peek());
                }
            }
        }
    }
}