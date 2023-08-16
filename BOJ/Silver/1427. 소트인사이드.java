package BOJ.Silver;

import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String N = scan.next();   //정렬할 수
        int[] arr = new int[N.length()];     
        for(int i=0; i<arr.length; i++){
            arr[i] = N.charAt(i) - '0';     //자릿수별로 분리
        }

        for(int i=0; i<arr.length; i++){
            int max = i;       //내림차순정렬이므로 최댓값으로 찾음
            for(int j=i+1; j<arr.length; j++){
                if(arr[max]< arr[j]){
                    max = j;   //현재 범위에서 max값 찾기
                }
            }

            //현재 i번째 배열의 값과 max가 더 크다면 swap
            if(arr[i] < arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
