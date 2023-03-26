// 진료순서 정하기
// import java.util.Arrays;
// import java.util.Collections;
// class Solution {
//     public int[] solution(int[] emergency) {
//         int[] answer = new int[emergency.length];
//         Integer[] copy_emergency = new Integer[emergency.length];
        
//         //배열 복사
//         System.arraycopy(emergency, 0, copy_emergency, 0, emergency.length);
//         //복사한 배열 오름차순 정렬
//         Arrays.sort(copy_emergency, Collections.reverseOrder());
        
//         for(int i=0; i<emergency.length; i++){
//             for(int j=0; j<emergency.length; j++){
//                 if(copy_emergency[i] == emergency[j]){
//                     answer[j] = i+1;
//                 }
//             }
//         }
//         return answer;
//     }
// }

//collection의 reverseOrder()사용하여 내림차순 정렬
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        
        Integer[] copy_emergency = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        //배열 오름차순 정렬
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