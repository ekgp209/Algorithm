package Lv0;
// 7의 개수
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        String str = "";
        
        //array의 값을 하나의 문자열로 저장
        for(int i=0; i<array.length; i++){
            str += (array[i]);
        }
        
        //각 문자랑 비교
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '7'){
                answer++;
            }
        }
        return answer;
    }
}