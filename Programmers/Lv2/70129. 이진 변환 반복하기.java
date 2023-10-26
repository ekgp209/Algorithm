package Lv2;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while(!s.equals("1")){
            String[] str = s.split("");
            String tmp = "";
            //1. s의 모든 0 제거
            for(int i=0; i<str.length; i++){
                if(str[i].equals("0")){
                    answer[1]++;
                }else{
                    tmp += str[i];
                }
            }

            //2. s의 길이 수를 2진법으로 변환
            int len = tmp.length();
            s = String.valueOf(Integer.toBinaryString(len));
            answer[0]++;
        }
        
        return answer;
    }
}