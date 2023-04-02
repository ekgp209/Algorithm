// 약수 구하기
class Solution {
    public int[] solution(int n) {
        int cnt = 0;

        // 약수의 개수 세기
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                cnt++;
            }
        }
        
        int[] answer = new int[cnt];
        cnt = 0;    //answer[0]부터 넣을 수 있도록 0으로 초기화
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                answer[cnt] = i;
                cnt++;
            }
        }
        return answer;
    }
}