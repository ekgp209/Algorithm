package BOJ.Silver;

import java.io.*;

class Main {
    static int[][] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        tree = new int[26][2];
        //트리 구조 저장
        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            int node = tmp[0].charAt(0) - 'A';      //index로 저장
            char left = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);

            if(left == '.'){
                tree[node][0] = -1;     //자식노드가 없다면 -1 저장
            }else{
                tree[node][0] = left - 'A';
            }

            if(right == '.'){
                tree[node][1] = -1;
            }else{
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    //전위 순회 (현재 -> 왼 -> 오)
    static void preOrder(int now){
        if(now == -1)     return;

        System.out.print((char)(now + 'A'));
        preOrder(tree[now][0]);     //왼쪽 탐색
        preOrder(tree[now][1]);     //오른쪽 탐색
    }

    //중위 순회 (왼 -> 현재 -> 오)
    static void inOrder(int now){
        if(now == -1)     return;

        inOrder(tree[now][0]);     //왼쪽 탐색
        System.out.print((char)(now + 'A'));
        inOrder(tree[now][1]);     //오른쪽 탐색
    }

    //후위 순회 (왼 -> 오 -> 현재)
    static void postOrder(int now){
        if(now == -1)     return;

        postOrder(tree[now][0]);     //왼쪽 탐색
        postOrder(tree[now][1]);     //오른쪽 탐색
        System.out.print((char)(now + 'A'));
    }
}
