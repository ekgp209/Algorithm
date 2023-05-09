// 해시 완주하지 못한 선수(for문 사용)
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++){
            if(!(participant[i].equals(completion[i]))){
                answer = participant[i];
                return answer;
            }
        }
        answer = participant[participant.length - 1];        
        return answer;
    }
}