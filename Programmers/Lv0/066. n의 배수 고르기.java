package Lv0;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int index = 0;
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n == 0){
                index++;
            }
        }
        
        int[] answer = new int[index];
        index = 0;
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n == 0){
                answer[index] = numlist[i];
                index++;
            }
        }
        return answer;
    }
}
