import java.util.Arrays;

// 최대값 만들기(2)
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
        
        int a1 = numbers[0]*numbers[1];
        int a2 = numbers[numbers.length-1]*numbers[numbers.length-2];
        answer = (a1 < a2) ? a2 : a1;
              
        return answer;
    }
}