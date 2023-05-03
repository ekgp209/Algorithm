import java.util.*;

class Solution {
    
    Set<Integer> numbersSet = new HashSet<>();
    
    public int solution(String numbers) {
        dfs("", numbers);
        
        int count = 0;
        Iterator<Integer> iter = numbersSet.iterator();
        while(iter.hasNext()){
            int number = iter.next();
            if(isPrime(number)){
                count++;
            }
        }    
        return count;
    }    
    
    //소수 판별
    public boolean isPrime(int num){
        if(num == 0 || num == 1){
            return false;
        }
        int limit = (int)Math.sqrt(num);

        for(int i=2; i<=limit; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
    
    //숫자 조합하기
    public void dfs(String str, String numbers){
        if(!str.equals("")){
            numbersSet.add(Integer.valueOf(str));
        }
        
        for(int i=0; i<numbers.length(); i++){
            dfs(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1));
        }
    }
}
