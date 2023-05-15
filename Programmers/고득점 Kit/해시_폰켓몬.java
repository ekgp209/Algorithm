import java.util.*;

class Solution {
    public int solution(int[] nums) {  
        
        Set<Integer> set = new HashSet<>();
        int res = nums.length/2;
        
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);   //폰켓몬 종류 수 만큼 set에 저장됨
        }
        
        if(set.size() <= res){
            return set.size();
        }else{
            return res;
        }
    }
}