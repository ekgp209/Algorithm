package Lv1;
// 평균 구하기
class Solution {
    public double solution(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        
        return (double)(sum / arr.length);
    }
}