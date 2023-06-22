package Lv1;

class Solution {
    public long solution(long n) {        
        for(long i=1; i<=Math.sqrt(n); i++){
            if(i*i == n){
                return (i+1)*(i+1);
            }
        }
        return -1;
    }
}