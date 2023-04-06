// 숫자 찾기
class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String s_num = Integer.toString(num);
        
        // num에 k가 없을 경우
        if(s_num.indexOf(Integer.toString(k)) == -1){
            answer = -1;
        }else{
            answer = s_num.indexOf(Integer.toString(k))+1;
        }
        return answer;
    }
}