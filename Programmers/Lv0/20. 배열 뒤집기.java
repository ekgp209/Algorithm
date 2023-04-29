package Lv0;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int cnt = answer.length - 1;
        
        for(int i=0; i<num_list.length; i++){
            answer[cnt] = num_list[i];
            cnt--;
        }
        return answer;
    }
}