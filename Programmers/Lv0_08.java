// 반복문 출력하기
// split() 메소드 사용
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        // split() 메소드로 문자 분리해서 배열 생성
        String str_split[] = my_string.split("");
        
        // 배열 각 자리마다 n번 반복
        for(int i=0; i<my_string.length(); i++){
            for(int j=0; j<n; j++){
                answer += str_split[i];
            }
        }
        return answer;
    }
}

// charAt() 메소드 사용
class Solution1 {
    public String solution(String my_string, int n) {
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++){
            //charAt()으로 각 자리 마다 n번 반복
            for(int j=0; j<n; j++){
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}