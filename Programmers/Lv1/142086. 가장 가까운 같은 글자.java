package Lv1;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            char nowChar = s.charAt(i);
            answer[i] = -1;

            for(int j=0; j<i; j++){
                if(nowChar == s.charAt(j)){
                    answer[i] = i - j;
                }
            }
        }
        return answer;
    }
}