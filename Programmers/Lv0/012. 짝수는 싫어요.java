package Lv0;

class Solution {
    public int[] solution(int n) {
        int[] answer = (n%2==0) ? new int[n/2] : new int[n/2+1];
        int num = 0;
        
        for(int i=1; i<=n; i++) {
            if(i%2 != 0) {
                answer[num] = i;
                num++;
            }        
        }
        return answer;
    }
}
