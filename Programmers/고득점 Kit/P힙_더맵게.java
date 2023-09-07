import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }

        while(pq.peek() < K){
            if(pq.size() == 1){     //모든 음식을 K이상으로 만들 수 없는 경우
                return -1;
            }

            int mix = pq.poll() + (pq.poll()*2);    //스코빌 지수가 가장 낮은 두 개의 음식 섞기
            pq.add(mix);
            answer++;
        }
        return answer;
    }
}