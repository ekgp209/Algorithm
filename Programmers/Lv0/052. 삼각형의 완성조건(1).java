package Lv0;

import java.util.Arrays;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        // 배열 오름차순 정렬하기
        Arrays.sort(sides);
        
        // 두 변의 길이가 가장 긴 변의 합보다 클 경우
        if(sides[0]+sides[1] > sides[2]){
            answer = 1;
        }else{
            answer = 2;
        }
        
        return answer;
    }
}