package BOJ.Silver;

import java.io.*;
import java.util.*;

//트라이 구조
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //문자열 개수
        int M = Integer.parseInt(st.nextToken());   //입력 문자열 수

        tNode root = new tNode();
        while(0 < N){
            String text = br.readLine();
            tNode now = root;

            for(int i=0; i<text.length(); i++){
                char c = text.charAt(i);
                //26개의 알파벳의 위치를 index로 나타내기 위해 '-a' 수행
                if(now.next[c - 'a'] == null){
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a'];
                if(i == text.length() - 1){
                    now.isEnd = true;
                }
            }
            N--;
        }

        int cnt = 0;
        while(0 < M){
            String text = br.readLine();
            tNode now = root;
            
            for(int i=0; i<text.length(); i++){
                char c = text.charAt(i);
                if(now.next[c - 'a'] == null){  //공백 노트라면 문자열 포함하지 않음
                    break;
                }
                now = now.next[c - 'a'];
                //문자열의 끝이고 현재까지 모두 일치한다면
                if(i == text.length() - 1 && now.isEnd){
                    cnt++;
                }
            }
            M--;
        }

        System.out.println(cnt);
    }

    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}
