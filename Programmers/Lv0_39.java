public class Lv0_39 {
    public static String[] solution(String[] quiz) {
        /* 
        1. 배열의 i번째를 가져와서 공백을 기준으로 새 배열에 담음
        2. 배열 0,2번째를 1번째 부호로 계산 -> 배열 4번쨰랑 같다면 "O"        
        */
        //String[] estimate = new String[5];

        String[] answer = new String[quiz.length];
        int idx = 0;
        
        for(int i=0; i<quiz.length; i++){
            String[] str = quiz[i].split(" ");
            
            int result = 0;
            if(str[1].equals("+")){
                result = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);
                if(result == Integer.parseInt(str[4])){
                    answer[idx] = "O";
                }else{
                    answer[idx] = "X";
                }
            }else if(str[1].equals("-")){
                result = Integer.parseInt(str[0]) - Integer.parseInt(str[2]);
                if(result == Integer.parseInt(str[4])){
                    answer[idx] = "O";
                }else{
                    answer[idx] = "X";
                }
            }
        }

        return answer;
    }
    
    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        Lv0_39.solution(quiz);
    }
}
