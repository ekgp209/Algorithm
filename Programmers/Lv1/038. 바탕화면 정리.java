package Lv1;

class Solution {
    public int[] solution(String[] wallpaper) {
        //lux, luy는 최소값 / rdx, rdy는 최댓값을 구해야 함
        int lux = 51;    //시작점 y좌표
        int luy = 51;    //시작점 x좌표
        int rdx = -1;    //끝점 y좌표
        int rdy = -1;    //끝점 x좌표
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(i, lux);
                    luy = Math.min(j, luy);
                    rdx = Math.max(i+1, rdx);
                    rdy = Math.max(j+1, rdy);
                }
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        return answer;
    }
}
