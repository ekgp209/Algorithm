package Lv0;

class Solution {
    public int solution(int n) {
        int answer = 0;
        //n이 1의자리가 될 때까지 10으로 나누기
        while(10 < n){
            answer += n%10;
            n /= 10;
        }
        
        //1의자리만 남았을 경우
        if(n < 10){
            answer += n;
        }
        return answer;
    }
}