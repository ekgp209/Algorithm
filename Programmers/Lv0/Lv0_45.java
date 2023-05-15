package Lv0;
// 캐릭터의 좌표
class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};

        //좌표에 따른 캐릭터 이동
        for(int i=0; i<keyinput.length; i++){
            if(keyinput[i].equals("right")){
                answer[0]++;
                //answer[0]이 가로 최대 길이보다 클 경우
                if(board[0]/2 < answer[0]){
                    answer[0] = board[0]/2;
                }
            }else if(keyinput[i].equals("left")){
                answer[0]--;
                if(answer[0] < -(board[0]/2)){
                    answer[0] = -(board[0]/2);
                }
            }else if(keyinput[i].equals("up")){
                answer[1]++;
                if(board[1]/2 < answer[1]){
                    answer[1] = board[1]/2;
                }
            }else if(keyinput[i].equals("down")){
                answer[1]--;
                if(answer[1] < -(board[1]/2)){
                    answer[1] = -(board[1]/2);
                }
            }
        }
        return answer;
    }
}