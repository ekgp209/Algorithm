package Lv0;

class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int len = common.length-1;
        
        //등차수열
        if((common[2]-common[1]) == common[1]-common[0]){
            answer = common[len] + (common[1]-common[0]);
        }
        
        //등비수열
        else if((common[2]/common[1]) == (common[1]/common[0])){
            answer = common[len] * (common[1]/common[0]);
        }

        return answer;
    }
}
