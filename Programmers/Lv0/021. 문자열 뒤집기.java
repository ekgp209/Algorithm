package Lv0;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        //charAt()메소드로 마지막 인덱스부터 answer에 담기
        for(int i=my_string.length()-1; i>=0; i--){
            answer += my_string.charAt(i);
        }
        return answer;
    }
}