class Solution {
    public long solution(int n) {
        int[] DP = new int[n + 1];
        
        DP[1] = 1;
        if(1 < n){
            DP[2] = 2;

            for(int i=3; i<=n; i++){
                DP[i] = (DP[i-1] + DP[i-2]) % 1234567;
            }
        }
        return DP[n];
    }
}