package Lv1;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        int seq = 1;
        for(int i=1; i<food.length; i++){
            while(food[i] > 0){
                if(food[i] == 1){
                    break;
                }

                answer += String.valueOf(seq);
                food[i] -= 2;
            }
            seq++;
        }

        answer += "0";

        for(int i=answer.length()-2; i>=0; i--){
            answer += answer.charAt(i);
        }

        return answer;
    }
}
