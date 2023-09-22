package Lv1;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] c = s.toCharArray();

        for(int i=0; i<c.length; i++){
            if(c[i] == ' '){
                answer += " ";
                continue;
            }

            for(int j=1; j<=n; j++){
                if(c[i] == 'z'){
                    c[i] = 'a';
                    continue;
                }else if(c[i] == 'Z'){
                    c[i] = 'A';
                    continue;
                }
                
                c[i] = (char)(c[i] + 1);
            }
            answer += c[i];
        }
        return answer;
    }
}