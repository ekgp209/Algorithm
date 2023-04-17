// 숨어있는 숫자의 덧셈(2)
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        //숫자가 아닌 문자를 공백으로 대체
        my_string = my_string.replaceAll("[^\\d]", " ");
        my_string = my_string.trim();   //선행, 후행 공백 제거
        
        String[] str = my_string.split(" ");
        for(int i=0; i<str.length; i++){
            answer += (!str[i].isEmpty()) ? Integer.parseInt(str[i]) : 0;
        }
        return answer;
    }
}