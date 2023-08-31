package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //수열의 길이
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());    //양수, 내림차순 정렬
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();     //음수, 오름차순

        int sum = 0;
        int zero = 0;
        int one = 0;
        for(int i=0; i<N; i++){
            int data = Integer.parseInt(br.readLine());
            if(data > 1){       //입력값이 양수인 경우
                plusPq.add(data);
            }else if(data < 0){ //입력값이 음수인 경우
                minusPq.add(data);
            }else if(data == 1){
                one++;
            }else{
                zero++;
            }
        }

        while(plusPq.size() > 1){
            int tmp = plusPq.poll() * plusPq.poll();
            sum += tmp;
        }
        if(!plusPq.isEmpty()){      //마지막 남은 하나의 원소도 더하기
            sum += plusPq.poll();
        }
        
        while(minusPq.size() > 1){
            int tmp = minusPq.poll() * minusPq.poll();
            sum += tmp;
        }
        if(!minusPq.isEmpty()){      //마지막 남은 하나의 원소도 더하기
            if(zero != 0){          
                sum += minusPq.poll() * 0;   //입력값에 0이 있는 경우 마이너스 요소 하나 없애기
            }else{
                sum += minusPq.poll();
            }
        }
        System.out.println(sum + one);
    }
}
