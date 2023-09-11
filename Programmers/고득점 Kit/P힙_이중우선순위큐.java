import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<String> strPq = new PriorityQueue<>();    //I or D
        PriorityQueue<Integer> numPq = new PriorityQueue<>();    //연산 할 수 or 삭제선택

        for(int i=0; i<operations.length; i++){
            String str = operations[i].split(" ")[0];       //문자
            int num = Integer.parseInt(operations[i].split(" ")[1]);    //숫자
            if()
            if(str.equals("I")){
                numPq.add(num);     //숫자 삽입
            }else{
                if(num == -1){
                    strPq.poll();
                }else{
                    //최댓값 삭제
                }
            }
        }
        int[] answer = {};
        
        return answer;
    }
}