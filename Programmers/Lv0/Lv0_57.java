package Lv0;
// 문자열 밀기
class Solution {
    public int solution(String A, String B) {
        int answer = 0; 
        
        //A와 B가 같을 경우
        if(A.equals(B)){
            return 0;
        }else{
            for(int i=1; i<A.length(); i++){
                String add = A.substring(A.length()-1);     //마지막 한 문자만 자르기
                A = add + A.substring(0, A.length()-1);     //자른 문자 +  0~마지막 전 문자까지 합치기
                answer++;
                if(A.equals(B)){
                    return answer;
                }
            }
        }  
        return -1;
    }
}