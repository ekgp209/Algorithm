package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test1 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //노드 수
        int M = Integer.parseInt(st.nextToken());   //간선(에지) 수

        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        
    }
}
