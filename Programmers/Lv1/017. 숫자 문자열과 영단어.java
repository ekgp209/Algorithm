package Lv1;

class Solution {
    public int solution(String s) {
        int answer = 0;
        answer = Integer.parseInt(s.replace("zero", "0").replace("one", "1").replace("two", "2")
                                  .replace("three", "3").replace("four", "4").replace("five", "5")
                                  .replace("six", "6").replace("seven", "7").replace("eight", "8")
                                  .replace("nine", "9"));
        return answer;
    }
}

class Solution1{
    public int solution(String s){
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<strArr.length; i++){
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}