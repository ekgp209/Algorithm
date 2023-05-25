package Lv1;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        //3진법으로 담기
        while(0 < n){
            list.add(n % 3);
            n /= 3;
        }
        
        //10진법으로 변환
        for(int i=0; i<list.size(); i++){
            answer += (Math.pow(3, list.size()-i-1)*list.get(i));
        }
        return answer;
    }
}