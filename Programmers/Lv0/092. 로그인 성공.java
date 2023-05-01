package Lv0;

class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        int idx = 0;
        
        for(int i=0; i<db.length; i++){
            //아이디가 일치할 경우
            if(id_pw[0].equals(db[i][0])){
                idx = i;
                //비밀번호도 일치할 경우
                if(id_pw[1].equals(db[idx][1])){
                    answer = "login";
                    break;
                }else{
                    answer = "wrong pw";
                    break;
                }
            }else{
                answer = "fail";
            }
        }
        return answer;
    }
}