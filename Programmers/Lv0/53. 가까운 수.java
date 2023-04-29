package Lv0;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int min = 100;  //n의 최대값이 100이므로
        
        for(int i=0; i<array.length; i++){
            int a = (Math.abs(array[i]-n)); //두 수의 차의 절대값 저장
            
            //min보다 a의 값이 작을 경우
            if(a < min){
                min = a;
                answer = array[i];
            }//a와 min이 같을 경우
            else if(a == min){
                //answer의 array[i]값 보다 a의 값이 더 클 경우
                if(answer < array[i]){
                    continue;
                }else{
                    min = a;
                    answer = array[i];
                }             
            }
        }
        return answer;
    }
}