package Lv1;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0);
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0; i<s.length(); i++){
            if(cnt1 == cnt2){
                answer++;
                first = s.charAt(i);
                cnt1 = 0;
                cnt2 = 0;
            }                
            if(s.charAt(i) == first){
                cnt1++;                  
            }else{
                cnt2++;
            }
        }
        return answer;
    }
}