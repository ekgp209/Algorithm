package Lv1;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            for(int j=0; j<index; j++){
                c += 1;
                if('z' < c) {       //z를 넘어갔을 경우 다시 a로
                    c -= 26;
                }
                if(skip.contains(String.valueOf(c))){
                    j--;
                }
            }
            answer += c;
        }
        
        
        return answer;
    }
}
