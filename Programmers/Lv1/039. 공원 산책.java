package Lv1;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int W = park[0].length();
        int H = park.length;
        char[][] board = new char[H][W];
        
        //시작지점(S) 찾기
        int[] sPosition = new int[2];       //{Y좌표, X좌표}
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                board[i][j] = park[i].charAt(j);
                if(park[i].charAt(j) == 'S'){
                    sPosition[0] = i;
                    sPosition[1] = j;
                }
            }
        }
        
        char now = 0;
        int nowY = sPosition[0];
        int nowX = sPosition[1];
        
        for(int i=0; i<routes.length; i++){
            String direction = routes[i].split(" ")[0];
            int move = Integer.parseInt(routes[i].split(" ")[1]);
            
            for(int j=1; j<=move; j++){
                switch(direction) {
                    case "E":   //동
                        if(sPosition[1]+move >= W) break;   //공원 이탈
                        now = board[sPosition[0]][sPosition[1]+j];
                        nowX = sPosition[1]+j;
                        break;
                    case "W":   //서
                        if(sPosition[1]-move < 0) break;   //공원 이탈
                        now = board[sPosition[0]][sPosition[1]-j];
                        nowX = sPosition[1]-j;
                        break;
                    case "S":   //남
                        if(sPosition[0]+move >= W) break;   //공원 이탈
                        now = board[sPosition[0]+j][sPosition[1]];
                        nowY = sPosition[0]+j;
                        break;
                    case "N":   //북
                        if(sPosition[0]-move < 0) break;   //공원 이탈
                        now = board[sPosition[0]-j][sPosition[1]];
                        nowY = sPosition[0]-j;
                        break;
                }
                if(now == 'X' || now == 0){                 //장애물을 만났을 때
                    nowY = sPosition[0];
                    nowX = sPosition[1];
                    break;
                }
            }
            if(now != 'X' && now != 0){
                sPosition[0] = nowY;
                sPosition[1] = nowX;
            }
        }
        return sPosition;
    }
}
