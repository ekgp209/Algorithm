package Lv0;
// 숨어있는 숫자의 덧셈(1)
class Solution {
    public int solution(String my_string) {
        char[] ch = my_string.toCharArray();  //toCharArray()로 문자열을 한 글자씩 쪼개서 배열에 저장
        String str = "";
        
        // ASCII코드 값(1~9 -> 49~57)으로 숫자인 문자만 골라서 str에 저장
        for(int i=0; i<ch.length; i++){
            if(49<=ch[i] && ch[i]<=57){
                str += ch[i];
            }
        }
        
        // str문자열을 split으로 분리한 후 answer에 더함
        int answer = 0;
        String[] str_arr = str.split("");
        for(int i=0; i<str_arr.length; i++){
            answer += Integer.parseInt(str_arr[i]);
        }
        return answer;
    }
}