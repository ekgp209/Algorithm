package Lv0;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] answer = new int[num2-num1+1];
        
        //arraycopy()메소드를 이용해 필요한 부분만 복사하여 return
        System.arraycopy(numbers, num1, answer, 0, answer.length);
        return answer;
    }
}