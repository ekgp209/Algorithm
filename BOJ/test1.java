package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test1 {
    public static void solution(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //N장의 카드
        Queue<Integer> cardQueue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            cardQueue.add(i);   //카드를 순서대로 큐에 저장
        }

        while(cardQueue.size() > 1){
            cardQueue.poll();   //맨 위 카드 버리기
            int tmp = cardQueue.peek();     //맨 위 카드 저장
            cardQueue.poll();
            cardQueue.add(tmp);
        }
        System.out.println(cardQueue.poll());
    }

    public static void main(String[] args) {
        solution();
    }
}
