package Lv1;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] charArr = s.toCharArray();

        int len = charArr.length;
        int mid = len / 2;
        if(len % 2 == 0){   //단어의 길이가 짝수인 경우
            answer += String.valueOf(charArr[mid-1]);
            answer += String.valueOf(charArr[mid]);
        }else{              //홀수인 경우
            answer = String.valueOf(charArr[mid]);
        }

        return answer;
    }
}
