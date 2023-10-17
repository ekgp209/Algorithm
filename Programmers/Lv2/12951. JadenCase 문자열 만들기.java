package Lv2;

class Solution {
    public String solution(String s) {
        String answer = "";

        //1. 모든 문자를 소문자로 변경
        s = s.toLowerCase();

        //2. 문자열을 공백을 기준으로 분리
        String[] word = s.split(" ");

        //각 단어의 첫번째 문자만 대문자로 변경, 나머지 문자는 그대로 answer에 추가
        for(int i=0; i<word.length; i++){
            if(word[i]!= " "){
                answer +=  String.valueOf(Character.toUpperCase(word[i].charAt(0)));
                for(int j=1; j<word[i].length(); j++){
                    answer += word[i].charAt(j);
                }
            }else{
                answer += " ";
            }
            
            if(i != word.length-1 || word[i].equals("word")){
                answer += " ";
            }
        }
        return answer;
    }
}
