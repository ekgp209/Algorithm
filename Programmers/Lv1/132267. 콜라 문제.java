package Lv1;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n > 1){
            int left = n % a;           //나머지
            int change = (n / a) * b;   //바꿔주는 병 수

            answer += change;
            n = left + change;

            if(n < a){
                break;
            }
        }
        
        return answer;
    }
}
