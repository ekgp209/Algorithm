package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   //N장의 카드
        Queue<Integer> cardQueue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            cardQueue.add(i);   //카드를 순서대로 큐에 저장
        }

        while(cardQueue.size() > 1){
            System.out.print(cardQueue.poll() + " ");   //버린 카드 출력
            int tmp = cardQueue.peek();     //맨 위 카드 저장
            cardQueue.poll();
            cardQueue.add(tmp);
        }
        System.out.print(cardQueue.poll());    //마지막 남은 카드 출력
    }
}