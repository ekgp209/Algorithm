package Lv1;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int win = 0;    //당첨 번호
        int zero = 0;   //알아볼 수 없는 번호
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
            }else{
                for(int j=0; j<win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        win++;
                        break;
                    }
                }
            }
        }
        
        answer[0] = (win+zero) > 1 ? (7-(win+zero)) : 6;
        answer[1] = win > 1 ? (7-win) : 6;
        
        return answer;
    }
}
