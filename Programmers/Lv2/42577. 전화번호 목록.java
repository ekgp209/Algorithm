package Lv2;

import java.util.*;

// HashSet
class Solution1 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(String phone : phone_book) {
            for(int i=1; i<phone.length(); i++){
                if(set.contains(phone.substring(0, i))){
                    return false;
                }
            }
        }
        return true;
    }
}


// for문
class Solution2 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].indexOf(phone_book[i]) == 0){
                return false;
            }
        }
        return true;
    }
}