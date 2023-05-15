package Lv2;
// 피보나치 수
class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] Fibo = new int[n+1];
        Fibo[0] = 0;
        Fibo[1] = 1;
        
        //F(n)까지의 각 피보나치 수 대입
        for(int i=2; i<=n; i++){
            Fibo[i] = (Fibo[i-1] + Fibo[i-2]) % 1234567;
        }
        answer = Fibo[n];
        return answer;
    }
}