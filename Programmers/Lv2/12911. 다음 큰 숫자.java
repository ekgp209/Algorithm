package Lv2;

class Solution {
    public int solution(int n) {
        int answer = 0;

        //Integer.bitCount() -> true bit (1)의 갯수를 반환해주는 함수
        int cnt = Integer.bitCount(n);    //n을 2진수로 변환했을 때 1의 갯수

        for(int i=n+1; n<=1000000; i++){
            int iCnt = Integer.bitCount(i);
            
            if(cnt == iCnt){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
