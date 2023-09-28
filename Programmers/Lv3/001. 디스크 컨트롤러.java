package Lv3;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        //jobs 요청 시간을 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                //작업 시간이 같은 경우
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];   //요청 시간이 빠른순으로 정렬
                }
                return o1[1] - o2[1];
            }
        });
        
        int cnt = 0;
        int endTime = 0;
        int sum = 0;
        int idx = 0;

        while(cnt < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= endTime){
                pq.add(jobs[idx++]);
            }
        }

        int answer = 0;

        return answer;
    }
}