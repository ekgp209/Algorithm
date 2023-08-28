// Stack
import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i : arr){
            //스택이 비어있거나, 맨 위(이전숫자)와 다른 경우 스택에 추가
            if(stack.isEmpty() || stack.peek() != i){
                stack.push(i);
            }
        }

        int[] answer = new int[stack.size()];
        for(int i=answer.length-1; i>=0; i--){
            answer[i] = stack.pop();   //순서대로 배열에 복사
        }
        return answer;

    }
}