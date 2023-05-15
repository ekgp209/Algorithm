package Lv0;
import java.util.Arrays;
import java.util.Comparator;

public class Lv0_50 {
    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {
        int answer = 0;
        
        Arrays.sort(dots, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        return answer;
    }
}
