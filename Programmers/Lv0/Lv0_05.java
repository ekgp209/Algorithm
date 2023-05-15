package Lv0;
// 피자 나눠먹기(2)
class Solution {
    public int solution(int n) {
        int answer = 1;
        
        while((6*answer)%n != 0){
            answer++;            
        }
        return answer;
    }
}