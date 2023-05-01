package Lv0;

import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);  //가장 긴 변 설정
        
        int sum = sides[0] + sides[1];
        for(int i=1; i<sum; i++){
            if((sides[0]+i) > sides[1]){
                answer++;
            }
        }
        return answer;
    }
}