package Lv0;

import java.util.Arrays;

class Solution {
    public int solution1(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);  //가장 긴 변 설정
        
        int min = sides[0];
        int max = sides[1];
        
        //가장 긴 변이 max인 경우
        for(int i=max-min+1; i<=max; i++){
            answer++;
        }
        
        //나머지 한 변이 가장 긴 변인 경우
        for(int i=max+1; i<max+min; i++){
            answer++;
        }
        
        return answer;
    }

    public int solution2(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);  //가장 긴 변 설정
        
        int sum = sides[0] + sides[1];      
        for(int i=1; i<sum; i++){
            //가장 긴 변이 sides[1]인 경우
            if(sides[1] < sides[0]+i && i <= sides[1]){
                answer++;
            }
            //나머지 한 변이 가장 긴 변인 경우
            else if(sides[1] < i && i < sum){
                answer++;
            }
        }
        return answer;
    }
}