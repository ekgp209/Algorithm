package Lv0;
// 분수의 덧셈
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        answer[0] = (denom2*numer1 + denom1*numer2);
        answer[1] = (denom1*denom2);
        
        //최대공약수 구하기
        int min = (answer[0] < answer[1]) ? answer[0] : answer[1];
        int gcd=1;
        for(int i=1; i<=min; i++){
            if(answer[0]%i==0 && answer[1]%i==0){
                gcd = i;
            }
        }
        
        answer[0] = answer[0] / gcd;
        answer[1] = answer[1] / gcd;
        
        return answer;
    }
}