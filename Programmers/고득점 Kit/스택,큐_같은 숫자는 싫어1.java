// ArrayList
import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        
       List<Integer> list = new ArrayList<>();
        
        int tmp = -1;   //원소 0~9에 영향가지 않는 아무 숫자
        
        for(int n : arr){
            if(tmp != n){
                list.add(n);
                tmp = n;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}