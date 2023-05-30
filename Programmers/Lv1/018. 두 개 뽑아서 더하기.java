package Lv1;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                hs.add(numbers[i]+numbers[j]);
            }
        }
        
        //HashSet을 List로 변환 후 정렬
        List<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}