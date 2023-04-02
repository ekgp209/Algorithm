// 암호해독
class Solution {
    public String solution(String cipher, int code) {
        String answer = "";
        String[] cipher_arr = cipher.split("");
        
        // 인덱스 시작이 0이므로 code-1부터 시작
        for(int i=(code-1); i<cipher.length(); i+=code){
            answer += cipher_arr[i];
        }
        return answer;
    }
}