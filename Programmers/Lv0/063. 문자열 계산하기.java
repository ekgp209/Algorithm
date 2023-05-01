package Lv0;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] s = my_string.split(" ");
        int result = 0;
        
        for(int i=1; i<s.length; i+=2){
            //배열 s의 홀수 값의 부호가 "+"일 경우
            if(s[i].equals("+")){
                //처음 계산으로 초기값 세팅
                if(i == 1){
                    result = Integer.parseInt(s[0]) + Integer.parseInt(s[2]);
                    answer = result;
                }else{
                    result = result + Integer.parseInt(s[i+1]);
                }  
            }
            //배열 s의 홀수 값의 부호가 "-"일 경우
            else if(s[i].equals("-")){
                if(i == 1){
                    result = Integer.parseInt(s[0]) - Integer.parseInt(s[2]);
                    answer = result;
                }else{
                    result = result - Integer.parseInt(s[i+1]);
                }   
            }
            answer = result;
        } 
        return answer;
    }
}