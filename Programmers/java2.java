// 배열 두 배 만들기
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = numbers[i]*2;
        }
        
        return answer;
    }
}