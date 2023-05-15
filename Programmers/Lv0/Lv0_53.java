package Lv0;
// 치킨 쿠폰
class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while(10 <= chicken){
            int remainder = chicken%10;
            answer += chicken/10;
            chicken = remainder + chicken/10;  //남은 쿠폰도 더해줌
        }
        
        return answer;
    }
}