// 없는 숫자 더하기
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        String num = "0123456789";
        int answer = 0;
        String str = Arrays.toString(numbers);  //numbers를 문자열로 변환
        
        for(int i=0; i<10; i++){
            // 해당 숫자가 포함되어 있지 않은 경우
            if(str.indexOf(num.charAt(i)) == -1){
                answer += (num.charAt(i) - '0');
            }
        }
        return answer;
    }
}