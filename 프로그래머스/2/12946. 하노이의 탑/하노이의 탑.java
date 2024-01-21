import java.util.*;

class Solution {
    static List<int[]> list;

    public int[][] solution(int n) {
        /*
         * 1. n-1개의 원판을 나머지 기둥으로 전부 옮긴다.
         * 2. n번 원판을 목적지 기둥으로 옮긴다.
         * 3. 나머지 n-1개의 원판을 목적지 기둥으로 옮긴다.
         */
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }

    //hanoi(n(원반수), from(출발지), other(경유지), to(목적지))
    static void hanoi(int n, int from, int other, int to){
        if(n == 1) {
            list.add(new int[]{from, to});
            return;
        }

        hanoi(n-1, from, to, other);    //1번기둥의 n-1개를 3번을 경유해 2번으로 이동
        list.add(new int[]{from, to});  //n번 원판을 3번으로 이동
        hanoi(n-1, other, from, to);    //2번기둥의 n-1개를 1번을 경유해 3번으로 이동
    }
}