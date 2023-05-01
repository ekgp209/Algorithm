package Lv0;

class Solution {
    public int[] solution(int[] array) {
        int[] answer = {0, 0};
        int max = 0;
        
        for(int i=0; i<array.length; i++){
            if(max < array[i]){
                max = array[i];
                answer[0] = max;
                answer[1] = i;
            }
        }
        return answer;
    }
}