package Lv0;
// 한 번만 등장한 문자
class Solution {
    public String solution(String s) {
        String answer = "";
        int[] cnt = new int[26];    //a~z -> 26개
        
        for(int i=0; i<s.length(); i++){
            // s의 각 문자에 해당하는 위치에 idx값 증가
            cnt[s.charAt(i) - 97] += 1; //ASCII코드 a=97 이므로, 해당 문자가 a라면 cnt[0] 의미
        }
        
        // 인덱스 값이 1인 문자만 출력
        for(int i=0; i<26; i++){
            if(cnt[i] == 1){
                answer += (char)(i + 97);
            }
        }
        return answer;
    }
}