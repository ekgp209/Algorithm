package Lv0;

class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        char ch_k = (char)(k + '0');            //비교를 위해 k를 char로 변경
        
        for(int a=i; a<=j; a++){
            String str = Integer.toString(a);   //숫자를 문자열로
            char[] ch = str.toCharArray();      //문자열을 char배열로
            
            for(int b=0; b<ch.length; b++){
                if(ch[b] == ch_k){              //각 자리 비교
                    answer++;
                }
            }
        }
        
        return answer;
    }
}