class Solution {
    public int solution(int[][] triangle) {
        int len = triangle.length;

        //아래부터 더한 값의 최댓값을 선택하며 올라가기
        for(int i=len-1; i>=0; i--){
            for(int j=0; j<i; j++){
                triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
            }
        }
        return triangle[0][0];
    }
}