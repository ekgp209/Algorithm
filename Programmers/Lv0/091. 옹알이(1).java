package Lv0;

class Solution {
    public int solution(String[] babbling) {
        String[] str = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<str.length; j++){
                babbling[i] = babbling[i].replace(str[j], " ");
            }
            
            if(babbling[i].trim().length() == 0){   //공백제거 후 빈 문자열이라면 answer++;
                answer++;
            }
        }
        return answer;
    }
}