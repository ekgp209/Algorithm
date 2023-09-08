package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());     //연산의 개수
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            //큐가 비어있는데 출력해야 할 경우
            if(pq.size() == 0 && x == 0){
                System.out.println("0");
                continue;
            }

            if(x != 0){
                pq.add(x);
            }else{
                System.out.println(pq.poll());
            }
        }
    }
}
