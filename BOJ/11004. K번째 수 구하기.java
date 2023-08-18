package BOJ;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, K;

    //피벗 구하기
    public static int partition(int[] arr, int left, int right){
        int mid = (left + right) / 2;
        swap(arr, left, mid);   //중앙 값을 첫번째 요소로 이동

        int pivot = arr[left];
        int i = left, j = right;
        
        while(i < j){
            while(pivot < arr[j]){
                j--;    //pivot보다 작은 수를 찾을 때 까지
            }

            while(i < j && arr[i] <= pivot){
                i++;     //pivot보다 큰 수를 찾을 때 까지
            }
            swap(arr, i, j);     //찾은 i와 j 교환
        }
        /* 반복문을 벗어난 경우: i와 j가 만난 경우
         * 현재 pivot과 교환
         */
        arr[left] = arr[i];
        arr[i] = pivot;

        return i;   //변경된 위치의 pivot 위치 return
    }

    //자리교환 함수
    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right){
            return;
        }

        int p = partition(arr, left, right);

        if(p == K-1){       //K번째 수 = arr[K-1]
            return;    
        }else if(p < K-1){
            quickSort(arr, p+1, right);
        }else{
            quickSort(arr, left, p-1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());    // 수의 개수
        K = Integer.parseInt(st.nextToken());    // K번째 수

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //퀵 정렬
        quickSort(arr, 0, N-1);

        System.out.println(arr[K-1]);
    }
}

