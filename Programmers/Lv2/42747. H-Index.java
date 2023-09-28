package Lv2;

import java.util.*;

//정렬
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int cnt = citations.length - i;        //논문 개수

            if(cnt <= citations[i]){                //뒤로 갈수록 cnt의 값이 작아지기 때문
                answer = cnt;       
                break;
            }  
        }  
        return answer;
    }
}