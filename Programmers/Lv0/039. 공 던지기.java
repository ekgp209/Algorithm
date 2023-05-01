package Lv0;

class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        
        // k-1번동안 수행하므로
        // k-1번동안 numbers의 인덱스를 2칸씩 이동시킨다.
        
        return answer = numbers[(k-1)*2 %numbers.length];
    }
}