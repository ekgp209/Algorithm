// 대문자와 소문자
class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] ch = my_string.toCharArray();
        
        for(int i=0; i<ch.length; i++){
            // 각 문자가 대문자일 경우('A'~'Z' -> 65~90)
            if(65<=ch[i] && ch[i]<=90){
                //문자를 문자열로 변환 후 소문자로 변경
                answer += String.valueOf(ch[i]).toLowerCase();  
            }// 소문자일 경우 -> 대문자로 변경
            else{
                answer += String.valueOf(ch[i]).toUpperCase();
            }
        }
        return answer;
    }
}