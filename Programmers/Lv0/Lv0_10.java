package Lv0;
// 진료순서 정하기
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


        // //모두가 진료를 받기 때문에 1로 초기화
        // for(int i = 0; i<answer.length; i++)
        // answer[i] = 1; 
    
        // //숫자끼리 비교하여 순서 정해줌. 이 부분에서 max를 이용해도 괜찮을 것 같음
        // for(int i = 0; i<emergency.length; i++){
        //     for(int j = i+1; j<emergency.length; j++){
        //         if(emergency[i] < emergency[j])
        //             answer[i] += 1;
        //     }
        // }
        return answer;
    }
}