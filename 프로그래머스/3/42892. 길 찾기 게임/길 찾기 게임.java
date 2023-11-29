import java.util.*;

class Node{
    int value;
    int x;
    int y;
    Node left;
    Node right;

    public Node(int value, int x, int y, Node left, Node right){
        this.value = value;
        this.x = x;
        this.y = y;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    static int[][] answer;
    static int idx;

    public int[][] solution(int[][] nodeinfo) {
        
        Node[] nodes = new Node[nodeinfo.length];

        for(int i=0; i<nodeinfo.length; i++){
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        }

        //y좌표: 내림차순, x좌표: 오름차순 정렬
        Arrays.sort(nodes, new Comparator<Node>() {
            public int compare(Node a, Node b){
                if(a.y == b.y){
                    return a.x - b.x;
                }
                return b.y - a.y;
            }
        });

        Node parent = nodes[0];     //y좌표 기준 가장 상위 노드(=루트)
        for(int i=1; i<nodes.length; i++){
            MakeTree(parent, nodes[i]);
        }
        
        answer = new int[2][nodeinfo.length];
        idx = 0;
        preOrder(parent);
        idx = 0;
        postOrder(parent);
               
        return answer;
    }

    static void MakeTree(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null){
                parent.left = child;
            }else{
                MakeTree(parent.left, child);
            }
        }else{
            if(parent.right == null){
                parent.right = child;
            }else{
                MakeTree(parent.right, child);
            }
        }
    }

    //전위 순회(현재 -> 왼 -> 오)
    static void preOrder(Node root){
        if(root != null){
            answer[0][idx++] = root.value;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //후위 순회(왼 -> 오 -> 현재)
    static void postOrder(Node root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            answer[1][idx++] = root.value;
        }
    }
}