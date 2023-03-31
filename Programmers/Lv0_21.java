// 2차원으로 만들기
import java.util.Arrays;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int idx = 0;
        
        // for문 활용
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[idx];
                idx++;
            }
        }

        //Arrays.copyOfRange() 메소드 활용
        for(int i=0; i<answer.length; i++){
            answer[i] = Arrays.copyOfRange(num_list, idx, idx+(n));
            idx += n;
        }
        return answer;
    }
}
