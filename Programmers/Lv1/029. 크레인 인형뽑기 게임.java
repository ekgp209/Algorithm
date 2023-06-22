package Lv1;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;     //사라진 인형 수
        List<Integer> basket = new ArrayList<>();
        
        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[j][moves[i]-1] > 0){
                    if((basket.size() > 0) && (basket.get(basket.size()-1) == board[j][moves[i]-1])){
                        basket.remove(basket.size()-1);
                        answer += 2;
                    }else{
                        basket.add(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}