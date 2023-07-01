package Lv1;

class Solution {
    public String solution(String new_id) {     
        //1단계: 소문자로 치환
        new_id = new_id.toLowerCase();       
        
        //2단계: 소문자, 숫자, -_. 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
        
        //3단계: .이 2개 이상있을 경우, .1개로 변경
        new_id = new_id.replaceAll("[.]{2,}", ".");
        
        //4단계: 처음과 끝에 위치한 . 제거
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        
        //5단계: 빈 문자열일 경우, a추가
        if(new_id.equals("")){
            new_id += "a";
        }
        
        //6단계: 길이가 16자 이상일 경우, 15자로 조정
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("[.]$", "");
        }
        
        //7단계: 길이가 2자 이하일 경우, 마지막문자 3자까지 반복
        if(new_id.length() <= 2){
            for(int i=new_id.length(); i< 3; i++){
                new_id += new_id.charAt(new_id.length()-1);
            }
        }

        return new_id;
    }
}