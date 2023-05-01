package Lv0;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=1000; i++){     //n의 최대값이 1000000이므로
            if(i*i == n){
                answer = 1;
                break;
            }else{
                answer = 2;
            }
        }
        return answer;
    }
}