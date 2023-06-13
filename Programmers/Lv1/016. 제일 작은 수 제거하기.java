package Lv1;

class Solution {
    public int[] solution(int[] arr) {
        //배열의 길이가 1인 경우
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }
        
        //배열의 길이가 1보다 큰 경우
        int[] answer = new int[arr.length -1];

        int min = arr[0];   //하나의 값을 기준으로 잡음
        for(int i=0; i<arr.length; i++){
            min = Math.min(min, arr[i]);
        }
        
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == min){
                continue;   //배열에 넣지 않고 넘어감
            }
            answer[idx++] = arr[i];
        }

        return answer;
    }
}