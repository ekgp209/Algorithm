package Lv1;

import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : ingredient){
            stack.push(i);
            
            if(4 <= stack.size()){      //햄버거의 재료가 4개 이상 모였을 경우
                if(stack.get(stack.size()-4) == 1 && stack.get(stack.size()-3) == 2 &&
                   stack.get(stack.size()-2) == 3 && stack.get(stack.size()-1) == 1){
                    answer++;
                    stack.pop(); stack.pop(); stack.pop(); stack.pop();     //4개의 재료를 삭제
                }
            }
        }
        return answer;
    }
}