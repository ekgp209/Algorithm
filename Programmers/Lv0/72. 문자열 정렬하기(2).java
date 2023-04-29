package Lv0;

import java.util.Arrays;
class Solution {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();    //문자열 소문자로 변경
        
        char[] chArr = my_string.toCharArray();
        Arrays.sort(chArr);
        
        String answer = new String(chArr);
        return answer;
    }
}