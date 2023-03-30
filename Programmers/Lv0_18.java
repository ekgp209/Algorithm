// 합성수 찾기
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++){
            int cnt = 0;    //i의 약수의 수
            
            for(int j=1; j<=i; j++){
                //i와 j가 약수인 경우
                if(i%j == 0){
                    cnt++;
                }
            }
            //약수가 3개 이상인 경우
            if(3 <= cnt){
                answer++;
            }
        }
        return answer;
    }
}