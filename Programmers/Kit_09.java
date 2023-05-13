// 완전탐색. 모의고사
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};    //5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};   //8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};   //10       
        int[] cnt = {0, 0, 0};  //수포자 정답 수
    
        //각 수포자의 정답 수 계산
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%5]) { cnt[0]++; }
            if(answers[i] == two[i%8]) { cnt[1]++; }
            if(answers[i] == three[i%10]) { cnt[2]++; }
        }
        
        //최대 점수 구하기
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<cnt.length; i++){
            if(max == cnt[i]){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}