package Lv1;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i=0; i<n; i++){
            answer[i] += x*(long)(i+1);     //long으로 변환하지 않으면 오버플로우 날 수 있음
        }
        return answer;
    }
}