package Lv1;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, HashSet<String>> reportMap = new HashMap<>();    //각 유저별 신고한 유저를 담은 map <신고된ID, 신고한ID>
        Map<String, Integer> countMap = new HashMap<>();            //신고된 유저의 신고 건수 <신고된ID, 메일 수>
        
        //Map 초기화
        for(int i=0; i<id_list.length; i++){
            reportMap.put(id_list[i], new HashSet<String>());       //유저ID, 신고한ID
            countMap.put(id_list[i], 0);
        }
        
        //신고 기록
        for(String s : report){
            String[] str = s.split(" ");
            String reporter = str[0];     //신고한ID
            String reported = str[1];     //신고된ID
            reportMap.get(reported).add(reporter);
        }
        
        //신고 횟수 카운트
        for(String reported : reportMap.keySet()){
            HashSet<String> sendUsers = reportMap.get(reported);
            
            //신고 수가 k이상인 경우
            if(sendUsers.size() >= k){
                for(String user : sendUsers){
                    countMap.put(user, countMap.get(user)+1);
                }
            }
        }
        
        for(int i=0; i<id_list.length; i++){
            answer[i] = countMap.get(id_list[i]);
        }
        
        return answer;
    }
}
