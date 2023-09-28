package Lv2;

import java.util.*;

//해시
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        //k:종류, v:개수 map에 추가
        for(int i=0; i<clothes.length; i++){
            if(map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], map.get(clothes[i][1])+1);   //key의 값에 +1하여 개수 추가
            }else{
                map.put(clothes[i][1], 1);
            }
        }
        
        int answer = 1;
        for(String key : map.keySet()){
            answer *= map.get(key) + 1;     //안입는 경우도 있으므로 +1
        }
 
        return answer-1;    //아무것도 안입었을 경우는 제외
    }
}
