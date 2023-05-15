package Lv0;
// 잘라서 배열로 저장하기
class Solution {
    public String[] solution(String my_str, int n) {
        int len = ((my_str.length()%n==0) ? my_str.length()/n : my_str.length()/n + 1);
        String[] answer = new String[len];
        int idx = 0;
        
        for(int i=0; i<answer.length; i++){
            answer[i] = "";     //초기값 null을 빈 문자열로 바꿈
        }
        
        for(int i=0; i<my_str.length(); i++){
            if(answer[idx].length() == n){      //문자열의 길이가 n일 경우
                idx++;
            }
            
            answer[idx] += my_str.charAt(i);
        }
        return answer;
    }
}