package Lv0;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        String[] s = my_string.split("");
        String tmp = "";
        
        tmp = s[num1];
        s[num1] = s[num2];
        s[num2] = tmp;
        
        //""를 구분자로 배열s를 문자열로 합쳐줌
        answer = String.join("", s);
        return answer;
    }
}