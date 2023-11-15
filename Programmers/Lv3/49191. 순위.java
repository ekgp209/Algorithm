package Lv3;

//그래프_플로이드워셜
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        boolean[][] check = new boolean[n + 1][n + 1];
        for(int i=0; i<results.length; i++){
            int a = results[i][0];
            int b = results[i][1];
            
            check[a][b] = true;
        }

        //floydWarshall
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(check[i][k] && check[k][j]){
                        check[i][j] = true;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                //역방향도 탐색하여 각 노드의 연결 확인후 카운트
                if(check[i][j] || check[j][i]){
                    cnt++;
                }
            }

            //자신을 제외한 모든 선수와 비교가 가능하다면 순위를 알 수 있음
            if(cnt == n-1)  answer++;
        }
        return answer;
    }
}
