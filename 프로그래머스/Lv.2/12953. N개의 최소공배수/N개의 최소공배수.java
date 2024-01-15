import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            st.push(arr[i]);
        }
        
        if(st.size() == 1){
            return st.peek();
        }
        
        while(st.size() > 1){
            int num1 = st.pop();
            int num2 = st.pop();

            long gcd = 1;

            for(int i=1; i<=num1; i++){
                if(num1 % i == 0 && num2 % i == 0){
                    gcd = i;
                }
            }

            gcd = (num1 * num2) / gcd;
            st.add((int)gcd);
        }

        return st.peek();
    }
}