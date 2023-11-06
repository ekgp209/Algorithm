package Lv2;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, String[] words) {
        List<String> list = new ArrayList<>();
        int[] answer = new int[2];      //{번호, 차례}

        int cnt = 1;    //차례
        list.add(words[0]);
        for(int i=0; i<words.length-1; i++){
            
            char e = words[i].charAt(words[i].length()-1);    //단어의 마지막 글자
            char s = words[i+1].charAt(0);              //뒷 단어의 첫 글자

            if((i+1)%n == 0){
                cnt++;
            }

            //중복된 단어가 아니고, 앞사람의 마지막 문자로 단어가 시작할 때
            if(!list.contains(words[i+1]) && e == s){
                list.add(words[i+1]);
            }else{
                //탈락자가 생기지 않을 경우, 기본으로 0이 저장되어있어 따로 값을 설정해주지 않아도 됨 {0, 0}
                answer[0] = ((i+1) % n) + 1;      //번호
                answer[1] = cnt;
                break;
            }
        }

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        return answer;
    }
}