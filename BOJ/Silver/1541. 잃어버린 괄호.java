package BOJ.Silver;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        String s = br.readLine();   //식

        String[] sArr = s.split("-");   //-를 기준으로 문자열 분리 -> 가장 큰 값을 빼주어야 하므로
        for(int i=0; i<sArr.length; i++){
            int midSum = 0;
            String[] tmp = sArr[i].split("\\+");   //+를 기준하여 숫자로 분리

            for(int j=0; j<tmp.length; j++){
                midSum += Integer.parseInt(tmp[j]);     //각 sArr[i]의 합을 구함
            }
            sArr[i] = String.valueOf(midSum);           //-계산을 위해 배열에 다시 저장

            if(i == 0){    //첫 번째 수는 더해줌
                answer = Integer.parseInt(sArr[i]);
            }else{
                answer -= Integer.parseInt(sArr[i]);
            }
        }
        System.out.println(answer);
    }
}
