package Lv2;

//스택/큐
class Solution {
    boolean solution(String s) {
        int cntL = 0;       // '(' 카운트
        int cntR = 0;       // ')' 카운트

        //첫 문자가 ")" 인 경우
        if(s.charAt(0) == ')'){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                cntL++;
            }else if(s.charAt(i) == ')'){
                cntR++;
            }

            if(cntL < cntR) return false;
        }

        //괄호가 바르게 짝지어지지 않은 경우
        if(cntL != cntR){
            return false;
        }

        return true;
    }
}