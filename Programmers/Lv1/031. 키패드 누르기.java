package Lv1;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;      //왼손 위치
        int right = 12;     //오른손 위치
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                answer += "L";
                left = numbers[i];
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                answer += "R";
                right = numbers[i];
            }else{
                if(numbers[i] == 0){    
                    numbers[i] = 11;    //0의 위치
                }

                //숫자로부터 왼손과 오른손 거리
                int l_hand = Math.abs(numbers[i]-left)/3 + Math.abs(numbers[i]-left)%3;
                int r_hand = Math.abs(numbers[i]-right)/3 + Math.abs(numbers[i]-right)%3;

                //2, 5, 8, 0일 경우
                if(l_hand == r_hand){
                    if(hand.equals("right")){
                        answer += "R";
                        right = numbers[i];
                    }else{
                        answer += "L";
                        left = numbers[i];
                    } 
                }else if(r_hand < l_hand){
                    answer += "R";
                    right = numbers[i];
                }else{
                    answer += "L";
                    left = numbers[i];
                }
            }
        }
        return answer;
    }
}