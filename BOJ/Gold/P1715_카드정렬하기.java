package BOJ.Gold;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715_카드정렬하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();     //카드 묶음 수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.add(scan.nextInt());     //낮은 숫자 순으로 우선순위 결정
        }

        int sum = 0;
        while(pq.size() > 1){       //비교할 값이 하나만 남을때까지
            int tmp = pq.poll() + pq.poll();
            sum += tmp;  //작은 수 두 개를 더해서 다시 큐에 추가
            pq.add(tmp);
        }
        System.out.println(sum);
    }
}
