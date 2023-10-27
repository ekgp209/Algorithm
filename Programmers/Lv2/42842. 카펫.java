package Lv2;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int sum = brown + yellow;
        int x = 0, y = 0;       //x: 가로, y: 세로

        for(int i=1; i<=yellow; i++){
            if(yellow % i == 0){
                //가로길이가 더 길어야 하므로
                x = Math.max(i, yellow / i);
                y = Math.min(i, yellow / i);

                if((y + 2) * (x + 2) == sum)    break;
            }
        }
        answer[0] = x + 2;
        answer[1] = y + 2;

        return answer;
    }
}