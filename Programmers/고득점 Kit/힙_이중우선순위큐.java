import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();   //최소 힙
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());   //최대 힙

        for(int i=0; i<operations.length; i++){
            String str = operations[i].split(" ")[0];       //문자
            int num = Integer.parseInt(operations[i].split(" ")[1]);    //숫자

            //빈 큐에 삭제 요청을 하는 경우
            if(minPq.size() == 0 && str.equals("D")){
                continue;
            }

            //"I"로 숫자 삽입 시 최소,최대 힙에 둘 다 넣기
            if(str.equals("I")){
                minPq.add(num);
                maxPq.add(num);
            }else{      //문자가 D일 때
                if(num == -1){
                   int min = minPq.poll();
                   maxPq.remove(min);
                }else{
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            }
        }

        int[] answer = new int[2];
        if(!minPq.isEmpty()){
            answer[0] = maxPq.poll();
            answer[1] = minPq.poll();
        }
        return answer;
    }
}