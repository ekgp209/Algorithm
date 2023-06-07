package Lv1;

import java.util.*;

class Solution {
    //ArrayList 사용
    public int[] solution1(int[] arr, int divisor) {
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0){
                list.add(arr[i]);
            }
        }
        
        //나누어떨어지는 element가 없을 경우
        if(list.isEmpty()){
            list.add(-1);
        }
        
        Collections.sort(list);
       
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }

    //stream 사용
    public int[] solution2(int[] arr, int divisor){
        int[] answer = Arrays.stream(arr).filter(element -> element%divisor==0).toArray();

        if(answer.length == 0){
            answer = new int[] {-1};
        }
        Arrays.sort(answer);

        return answer;
    }
}
