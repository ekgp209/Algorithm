package Lv1;

import java.util.*;

//스택/큐
// Stack
class Solution1 {
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

// ArrayList
class Solution2 {
    public int[] solution(int []arr) {
        
       List<Integer> list = new ArrayList<>();
        
        int tmp = -1;   //원소 0~9에 영향가지 않는 아무 숫자
        
        for(int n : arr){
            if(tmp != n){
                list.add(n);
                tmp = n;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

// for
class Solution3 {
    public int[] solution(int []arr) {
        int cnt = 1;
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                cnt++;
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<arr.length-1; i++){
           if(arr[i] != arr[i+1]){
               answer[idx] = arr[i];
               idx++;
            }
            
        }
        answer[cnt-1] = arr[arr.length-1];
        return answer;
    }
}