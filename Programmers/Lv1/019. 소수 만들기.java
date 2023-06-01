package Lv1;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum = nums[i]+nums[j]+nums[k];    //3개 더한 값
                    
                    if(isPrime(sum)){                 //소수 찾기
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
        

    public boolean isPrime(int num){
        if(num < 0){        //0,1 제외
            return false;
        }

        for(int i=2; i<num; i++){
            if(num % i == 0){       //나누어 떨어지면 소수X
                return false;
            }
        }
        return true;
    }
}