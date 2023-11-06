package Lv1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        //이름과 그리움 점수를 매치
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                String findName = photo[i][j];

                //일치하는 이름이 있다면 해당 value를 answer에 추가
                if(map.containsKey(findName)){
                    answer[i] += (int)map.get(findName);
                }
            }
        }
        return answer;
    }
}
