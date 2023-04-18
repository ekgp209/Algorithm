// 직사각형 넓이 구하기
class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x=0, y=0;
        
        for(int i=0; i<4; i++){     //4->dots의 길이
            if(dots[0][0] == dots[i][0]){
                y = i;
            }
            if(dots[0][1] == dots[i][1]){
                x = i;
            }
        }
        answer = Math.abs(dots[0][0]-dots[x][0]) * Math.abs(dots[0][1]-dots[y][1]);     //x*y
        return answer;
    }
}