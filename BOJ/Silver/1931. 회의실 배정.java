package BOJ.Silver;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //회의의 수
        int[][] time = new int[N][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");   //공백 단위로 끊음
            time[i][0] = Integer.parseInt(st.nextToken());  //시작시간
            time[i][1] = Integer.parseInt(st.nextToken());  //종료시간
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                //회의 종료시간이 같은 경우
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];   //사작시간이 빠른순으로 정렬
                }
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int endTime = 0;    //직전 회의 종료시간
        for(int i=0; i<N; i++){
            //직전 종료시간이 다음 회의 시작시간보다 작거나 같은 경우
            if(endTime <= time[i][0]){
                endTime = time[i][1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
