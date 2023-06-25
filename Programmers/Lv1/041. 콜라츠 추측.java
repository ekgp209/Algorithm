package Lv1;

class Solution {
    public int solution(int num) {
        long answer = 0;
        long numL = (long)num;      //int사용시 작업을 많이 반복하면 오버플로우 발생
        
        if(numL == 1){
            return 0;
        }
        
        while(numL != 1){
            //1-1. num이 짝수일 경우
            if(numL % 2 == 0){
                numL = numL / 2;
                answer++;
            }
            //1-2. num이 홀수일 경우
            else{
                numL = numL*3 + 1;
                answer++;
            }  
            
            //작업을 500번 반복했을 경우
            if(answer == 500){
                return -1;
            }
        }
        
        return (int)answer;
    }
}