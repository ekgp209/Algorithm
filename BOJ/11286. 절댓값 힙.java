package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());   //N개의 연산 수

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) > Math.abs(o2)) {
                    return 1;           //o2뒤에 o1추가
                }else if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;     //음수: o2앞에, 양수: o2뒤에 추가
                }else{
                    return -1;          //o2앞에 o1추가
                }
            }
        });

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0){
                if(pq.isEmpty()){       //배열이 비어있는 경우
                    System.out.println("0");
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(num);
            }    
        }
    }
}
