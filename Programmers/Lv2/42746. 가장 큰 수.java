package Lv2;

import java.util.*;

//정렬
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        //문자열을 리턴해줄 스트링 배열 생성
        String[] str = new String[numbers.length];
        
        //int -> String으로 변환
        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        
        //내림차순 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        //0이 중복일 경우 ex){0,0,0} 답이 000이면 안되므로 첫번째값이 0이면 return 0
        if(str[0].equals("0")){
            return "0";
        }
        //0이 아니면 문자열 더해줌
        for(String s : str){
            answer += s;
        }
        return answer;
    }
}