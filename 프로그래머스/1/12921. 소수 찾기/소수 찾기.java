import java.util.*;

class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[1000001];
        ArrayList<Integer> prime_numbers = new ArrayList<>();
        
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=n; i++){  //i의 배수 제외시키기
            if(!prime[i]){
                for(int j=i*i; j<=n; j+=i){
                    prime[j] = true;
                }
            }
        }
        
        for(int i=1; i<=n; i++){
            if(!prime[i])   prime_numbers.add(i);
        }
        
        return prime_numbers.size();
    }
}