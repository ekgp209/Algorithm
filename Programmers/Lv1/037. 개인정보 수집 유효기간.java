package Lv1;

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        //terms를 Map으로 변경 <약관종류, 유효기간>
        Map<String, Integer> expireDate = new HashMap<>();
        for(String term : terms) {
            String type = term.split(" ")[0];
            int date = Integer.parseInt(term.split(" ")[1]);
            
            expireDate.put(type, date);
        }
        
        //today를 int로 변경
        int todayInt = Integer.parseInt(today.replace(".", ""));
        
        for(int i=0; i<privacies.length; i++) {
            //수집된 날짜와 약관 종류 추출
            int date = Integer.parseInt(privacies[i].split(" ")[0].replace(".", ""));
            String type = privacies[i].split(" ")[1];
            
            //연/월/일로 나누기
            int year = date/10000;
            int month = (date%10000)/100;
            int day = date%100;
            
            month += expireDate.get(type);
            if(month > 12) {
                year += (month/12);     //유효기간이 최대 100달 이므로
                month = month-12*(month/12);
                
                if(month == 0) {
                    month = 12;
                    year -= 1;
                }
            }
             
            date = year*10000 + month*100 + day;
            if(date <= todayInt) {
                answer.add(i);
            }
        }
        
        int[] answerArr = new int[answer.size()];
        for(int i=0; i<answerArr.length; i++) {
            answerArr[i] = answer.get(i)+1;
        }
        
        return answerArr;
    }
}
