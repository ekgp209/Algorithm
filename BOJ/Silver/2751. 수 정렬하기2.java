package BOJ.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static int[] arr, tmp;    //정렬할 배열, 합치는 과정에서 정렬하여 원소를 담을 임시배열

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, N-1);

        for(int i=0; i<arr.length; i++){
            bw.write(String.valueOf(arr[i] + " "));
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int arr[], int left, int right){
        //if(left == right) return;   //부분리스트가 1개의 원소만 갖고있는 경우

        if(left < right){           //분할이 가능하다면
            int mid = (left + right) / 2;   //중앙 인덱스

            mergeSort(arr, left, mid);     //중앙값 왼쪽 분할
            mergeSort(arr, mid+1, right);  //중앙값 오른쪽 분할
            merge(arr, left, mid, right);   //병합
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int l = left;   //왼쪽 부분리스트 시작점
        int r = mid + 1;    //오른쪽 부분리스트 시작점
        int idx = left;     //merge할 배열의 인덱스

        while(l <= mid && r <= right){
            /*
             * 왼쪽 부분리스트의 1번째 원소가 오른쪽 r번째 원소보다 작거나 같은 경우,
             * 왼쪽의 1번째 원소를 임시 배열에 넣고 l과 idx 증가
             */
            if(arr[l] <= arr[r]){
                tmp[idx] = arr[l];
                idx++;
                l++;
            }else{      //오른쪽 부분리스트의 r번째 원소가 왼쪽 1번째 원소보다 작은 경우
                tmp[idx] = arr[r];
                idx++;
                r++;
            }
        }

        //왼쪽 부분리스트가 먼저 모두 임시 배열에 채워졌을 경우(mid < l)
        //= 오른쪽 부분리스트의 원소가 아직 남아있을 경우
        if(mid < l){
            while(r <= right){
                tmp[idx] = arr[r];
                idx++;
                r++;
            }
        }else{      //오른쪽 부분리스트의 원소가 먼저 모두 채워졌을 경우
            while(l <= mid){
                tmp[idx] = arr[l];
                idx++;
                l++;
            }
        }

        //정렬된 임시배열을 원본 배열에 복사
        for(int i=left; i<=right; i++){
            arr[i] = tmp[i];
        }
    }
}
