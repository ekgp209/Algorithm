import java.io.*;
import java.util.*;

public class Main{
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int N;

    static class Node{
        int end;
        int weight;

        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());       //노드 수
        int M = Integer.parseInt(st.nextToken());   //노드쌍 수

        tree = new ArrayList[N + 1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e, w));
            tree[e].add(new Node(s, w));
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(BFS(s, e));
        }
    }

    static int BFS(int s, int e){
        visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(s, 0));
        visited[s] = true;

        int dist = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            //목적지에 도달했을 경우
            if(node.end == e){
                dist = node.weight;
                break;
            }

            for(Node tmp : tree[node.end]){
                if(!visited[tmp.end]){
                    queue.add(new Node(tmp.end, node.weight + tmp.weight));
                    visited[tmp.end] = true;
                }
            }
        }
        return dist;
    }
}