package Lv0;

import java.util.Arrays;
import java.util.Collections;

//collection의 reverseOrder()사용하여 내림차순 정렬
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        Integer[] copy_emergency = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        //배열 내림차순 정렬
        Arrays.sort(copy_emergency, Collections.reverseOrder());
        
        for(int i=0; i<emergency.length; i++){
            for(int j=0; j<emergency.length; j++){
                if(copy_emergency[i] == emergency[j]){
                    answer[j] = i+1;
                }
            }
        }
        return answer;
    }
}