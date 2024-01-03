import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(tangerine);
        
        int before = tangerine[0];
        int cnt = 0;
        //귤 종류의 갯수만 파악
        for(int i : tangerine){
            if(before == i){
                cnt++;
            }else{
                pq.add(cnt);
                before = i;
                cnt = 1;
            }
        }

        pq.add(cnt);

        while(0 < k){
            int n = pq.poll();
            System.out.println(n);

            k -= n;
            answer++;
        }

        return answer;
    }
}