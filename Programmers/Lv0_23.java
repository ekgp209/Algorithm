// 컨트롤 제트
class Solution {
    public int solution(String s) {
        String[] s_str = s.split(" ");  //공백을 기준으로 문자열 나눔
        int answer = 0;
        
        for(int i=0; i<s_str.length; i++){
            // "Z"가 나왔을 경우
            if(s_str[i].equals("Z")){
                answer -= Integer.parseInt(s_str[i-1]);
            }else{
                answer += Integer.parseInt(s_str[i]);
            }          
        }
        return answer;
    }
}