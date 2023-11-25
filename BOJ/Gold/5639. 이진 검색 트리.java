package BOJ.Gold;

import java.io.*;

class Main {
    static class Node{
        int num;
        Node left, right;
        
        Node(int num){
            this.num = num;
        }

        void insert(int num){
            if(num < this.num){         //현재 노드보다 작은 경우
                if(this.left == null){
                    this.left = new Node(num);
                }else{
                    this.left.insert(num);
                }
            }else{
                if(this.right == null){
                    this.right = new Node(num);
                }else{
                    this.right.insert(num);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //처음 입력되는 값이 root이므로 먼저 root 노드 생성
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        while(true){
            String num = br.readLine();
            if(num == null){
                break;
            }
            root.insert(Integer.parseInt(num));
        }
        postOrder(root);
    }

    //후위 순회 (왼 -> 오 -> 현재)
    static void postOrder(Node node){
        if(node.left != null){
            postOrder(node.left);   //왼쪽 탐색
        }
        if(node.right != null){
            postOrder(node.right);  //오른쪽 탐색
        }
        System.out.println(node.num);
    }
}
