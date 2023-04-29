package Lv0;

class Solution {
    public String solution(String rsp) {
        String answer = "";

        for(int i=0; i<rsp.length(); i++){
            char charRsp = rsp.charAt(i);
            if(charRsp == '2'){
                answer += "0";
            }else if(charRsp == '0'){
                answer += "5";
            }else if(charRsp == '5'){
                answer += "2";
            }
        }
        return answer;
    }
}