package Lv0;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        answer = (n*12000) + (k*2000);
        if(10 <= n){
            answer -= (n/10)*2000;
        }
        
        return answer;
    }
}