package Lv2;

import java.util.Stack;

class Solution{
    public int solution(String s){
        /*
         * 스택에 한글자씩 넣으면서 맨 윗부분과 넣어야할 문자가 같다면, 문자를 넣지 않고 pop,
         * 문자가 다르다면 push;
         */
        Stack<Character> stack = new Stack<>();
        int idx = 0;

        if(s.length() == 0) return 0;

        stack.push(s.charAt(idx++));
        while(idx < s.length()){
            char c = s.charAt(idx++);

            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}