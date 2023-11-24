package BOJ.Silver;

import java.io.*;
import java.util.*;

class Main {
    static int[] tree;
    static List<Integer>[] treeList;
    static int K;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());    //트리의 깊이

        int nodeNum = (int)Math.pow(2, K) - 1;
        tree = new int[nodeNum];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<nodeNum; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        treeList = new ArrayList[K];
        for(int i=0; i<K; i++){
            treeList[i] = new ArrayList<>();
        }

        inOrder(0, nodeNum-1, 0);

        for(int i=0; i<K; i++){
            for(int j : treeList[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void inOrder(int s, int e, int depth){
        if(depth == K)   return;

        int mid = (s + e) / 2;

        treeList[depth].add(tree[mid]);
        inOrder(s, mid - 1, depth + 1);     //왼쪽 노드(시작 ~ 중간-1 까지)
        inOrder(mid + 1, e, depth + 1);     //오른쪽 노드(중간+1 ~ 끝 까지)
    }
}
