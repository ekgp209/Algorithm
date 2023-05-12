// 완전탐색. 최소직사각형
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_w  = 0;
        int max_h = 0;
        
        //가장 긴 가로,세로 길이 찾기
        for(int i=0; i<sizes.length; i++){
            if(max_w < sizes[i][0]){
                max_w = sizes[i][0];           //가로
            }
            if(max_h < sizes[i][1]){
                max_h = sizes[i][1];           //세로
            }
            
            if(sizes[i][1] <= max_w && sizes[i][0] <= max_h){
                   
            }
        }
        
        answer = max_h*max_w;
        return answer;
    }
}