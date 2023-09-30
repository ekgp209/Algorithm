package Lv1;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ", -1);   //공백을 기준으로 자르되, 마지막 빈 값도 배열에 저장
        
        for(int i=0; i<sArr.length; i++){
            for(int j=0; j<sArr[i].length(); j++){
                char c = sArr[i].charAt(j);

                if(j % 2 == 0){     //짝수 인덱스
                    answer += Character.toUpperCase(c);
                }else{              //홀수 인덱스
                    answer += Character.toLowerCase(c);
                }
            }
            
            if(i != sArr.length-1){
                answer += " ";  //단어 사이에 공백 추가
            }
        }
        
        return answer;
    }
}