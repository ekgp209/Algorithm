package Lv1;

class Solution {
    public int[] solution(long n) {
        String s = String.valueOf(n);   //문자열로 변환
        
        int[] answer = new int[s.length()];
        int idx = 0;
        for(int i=answer.length-1; i>=0; i--){
            answer[idx] = s.charAt(i) - '0';
            idx++;
        }
        return answer;
    }
}