package Lv1;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        /*
         * return 값은 String을 비교 할 시 왼쪽이 클 때는 양수 값, 같을 때는 0, 오른쪽이 클 때는 음수로 생각하기
         */

        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(o1.charAt(n) > o2.charAt(n)){
                    return 50;
                }else if(o1.charAt(n) < o2.charAt(n)){
                    return -50;
                }else if(o1.charAt(n) == o2.charAt(n)){
                    return o1.compareTo(o2);
                }
                return 0;
            }
        });
        return strings;
    }
}
