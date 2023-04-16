public class Lv0_47 {
    public static String solution(String polynomial) {
        /*
        1. 공백.덧셈.공백을 기준으로 자름
        2. 각 문자를 2차원 배열로 저장
        3. [i][1]이 x라면 x끼리 더함 -> answer[0]에 저장
        */
        String answer = "";
        
        String[] str = polynomial.split(" + ");
        String[][] strArr = new String[str.length][2];
        
        for(int i=0; i<str.length; i++){
            strArr[i] = str[i].split("");
            System.out.println(strArr[i]);
        }
        
        int x = 0;  //~x값
        int n = 0;  //정수
        for(int i=0; i<strArr.length; i++){
            if(strArr[i][1].equals("x")){
                x += Integer.parseInt(strArr[i][0]);
            }else{
                n += Integer.parseInt(strArr[i][0]);
            }
        }
        
        if(x == 0){                     //정수만 있을 경우
            answer = Integer.toString(n);
        }else if(x != 0){               //~x만 있을 경우
            answer = Integer.toString(x) + "x";
        }else if(x != 0 && n != 0){     //~x와 정수 둘 다 있을 경우
            answer = Integer.toString(x) + "x + " + Integer.toString(n);
        } 
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        String polynomial = "3x + 7 + x";
        solution(polynomial);
    }

}
