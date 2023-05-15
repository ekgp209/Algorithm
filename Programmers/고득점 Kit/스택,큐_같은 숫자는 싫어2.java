class Solution {
    public int[] solution(int []arr) {
        int cnt = 1;
        
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                cnt++;
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<arr.length-1; i++){
           if(arr[i] != arr[i+1]){
               answer[idx] = arr[i];
               idx++;
            }
            
        }
        answer[cnt-1] = arr[arr.length-1];
        return answer;
    }
}