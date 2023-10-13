package Lv2;

class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        String max = nums[0];
        String min = nums[0];

        for(int i=1; i<nums.length; i++){
            if(Integer.parseInt(max) < Integer.parseInt(nums[i]))   max = nums[i];  //최댓값

            if(Integer.parseInt(nums[i]) < Integer.parseInt(min))   min = nums[i];  //최솟값
        }
        
        return min + " " + max;
    }
}