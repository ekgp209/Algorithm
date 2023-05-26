package Lv1;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++){
            // 10진수 -> 2진수 변환
            String tmp = "";
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);
            
            //자리수 맞추기
            while(bin1.length() < n){
                bin1 = "0"+bin1;
            }
            while(bin2.length() < n){
                bin2 = "0"+bin2;
            }
            
            //지도1, 2 해독
            for(int j=0; j<n; j++){
                if(bin1.charAt(j) == '1' || bin2.charAt(j) == '1'){
                    tmp += "#";
                }else{
                    tmp += " ";
                }
            }
            answer[i] = tmp;
        }
        return answer;
    }
}
