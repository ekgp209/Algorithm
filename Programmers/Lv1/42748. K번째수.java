package Lv1;

import java.util.Arrays;

//정렬
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            //해당 원소끼리 정렬할 수 있느 배열 생성
            int[] tmp = new int[commands[i][1]-commands[i][0]+1];
            int idx = 0;
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                tmp[idx] = array[j];
                idx++;
            }
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}