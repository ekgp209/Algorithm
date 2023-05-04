package Lv1;

class Solution {
    public int solution(int n) {
        int answer = 0;

        while(0<n){
            if(10 <= n){
                answer += n%10;
                n /= 10;
            }else{
                answer += n;
                n = 0;
            }
        }
        return answer;
    }
}
