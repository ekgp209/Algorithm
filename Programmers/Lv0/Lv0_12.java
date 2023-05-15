package Lv0;
// 개미 군단
class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        while(hp != 0){
            //체력을 5(장군개미)로 나눌 수 있는 경우
            if(hp >= 5 && (hp%5) >= 0){
                answer += hp/5;
                hp %= 5;
            }
            //체력을 3(병정개미)로 나눌 수 있는 경우
            else if(hp >= 3 && (hp%3) >= 0){
                answer += hp/3;
                hp %= 3;
            }
            //5와 3으로도 나눌 수 없는 경우(체력이 1,2인 경우)
            else{
                answer += hp;
                hp = 0;
            }
        }
        return answer;
    }
}