package Lv0;

class Solution {
    public int solution(int balls, int share) {
        double answer = 1;
        int nmFac = 1;

        if(balls == share){
            answer = 1;
        }else {
            //(n!/m!을 계산한 값) / (n-m)!
            for(int i=balls; i>share; i--){
                answer = (answer*i) / nmFac;
                nmFac++;
            }
        }
        return (int)answer;
    }
}
