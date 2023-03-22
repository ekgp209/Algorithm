package Lv1;

class Solution {
    boolean solution(String s) {
        int cntP = 0;
        int cntY = 0;

        String sL = s.toLowerCase();
        for(int i=0; i<sL.length(); i++){
            char ch = sL.charAt(i);
            if(ch == 'p'){
                cntP++;
            }else if(ch =='y'){
                cntY++;
            }
        }
        
        if(cntP == cntY || (cntP==0 && cntY==0)){
            return true;
        }else{
            return false;
        }
    }
}