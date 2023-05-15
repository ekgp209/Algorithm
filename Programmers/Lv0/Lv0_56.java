package Lv0;
class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int idx = 0;
        int odd = (total/num) - (num/2);
        int even = (total/num) - (num/2) +1;
        
        //num이 홀수일 때
        if(num%2 != 0){
            for(int i=0; i<num; i++){
                answer[i] = odd;
                odd++;
            }
        }
        
        //num이 짝수일 때
        if(num%2 == 0){
            for(int i=0; i<num; i++){
                answer[i] = even;
                even++;
            }
        }   
        return answer;
    }
}