package Lv1;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {        
        double[] failCnt = new double[N+1];   //스테이지에 머물러있는 사용자 수
        
        //시도자, 실패자 카운트
        for(int stage : stages) {
            //마지막 스테이지를 깨지 않았을 경우
            if(stage != N+1){
                failCnt[stage]++;
            }
        }
        
        //실패율
        List<Double> rate = new ArrayList<>();
        
        //실패율을 구한 후 다시 stage배열에 담고, rate 리스트에도 담음
        double tmp = 0;
        double num = stages.length;
        for(int i=1; i<failCnt.length; i++){
            tmp = failCnt[i];
            if(num == 0){
                failCnt[i]=0;
            }else{
                failCnt[i] = failCnt[i]/num;
                
                num = num - tmp;
            }
            rate.add(failCnt[i]);
        }
        
        Collections.sort(rate, Collections.reverseOrder());
        
        //rate값과 failCnt값을 비교해서 같으면 stage의 index 번호를 가져옴으로써 실패율이 높은 순으로 넣어줌
        int[] answer = new int[N];
        for(int i=0; i<rate.size(); i++){
            for(int j=1; j<failCnt.length; j++){
                if(rate.get(i) == failCnt[j]){
                    answer[i] = j;
                    failCnt[j] = -1;
                    break;
                }
            }
            
        }
        return answer;
    }
}
