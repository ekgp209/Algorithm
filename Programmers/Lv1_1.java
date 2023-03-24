// 최대공약수와 최소공배수
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {0, 0};
        
        //작은 값 찾기
        int min = (n<m ? n : m);
        
        //최대공약수
        for(int i=1; i<=min; i++){
            if(n%i==0 && m%i==0){
                answer[0] = i;
            }
        }
        
        //최소공배수
        answer[1] = (n * m)/answer[0];
        
        return answer;
    }
}