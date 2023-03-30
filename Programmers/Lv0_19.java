// 문자열 정렬하기(1)
import java.util.Arrays;
class Solution {
    public int[] solution(String my_string) {
        String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] temp = my_string.split("");    //my_string 분리해서 배열에 각각 저장
        String my_strr = "";
        //int tmp = 0;
        
        //문자열에서 숫자고르기
        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<number.length; j++){
                if(temp[i].equals(number[j])){
                    my_strr += number[j];
                } 
            }
        }
        
        //answer에 골라낸 숫자 복사
        int[] answer= new int[my_strr.length()];
        String[] tmp = my_strr.split("");   //숫자만 골라낸 my_strr을 분리해서 배열에 저장
        for(int i=0; i<my_strr.length(); i++){
            answer[i] = Integer.parseInt(tmp[i]);
        }
        
        Arrays.sort(answer);
        return answer;
    }
}