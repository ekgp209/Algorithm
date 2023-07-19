package Lv1;

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();     // <선수명, 등수>
        
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        for(String player : callings){
            //등수 호출
            int rank = map.get(player);
            //앞 선수 호출
            String beforePlayer = players[rank-1];
            
            //players 배열 갱신
            players[rank-1] = player;
            players[rank] = beforePlayer;
            
            //map 갱신
            map.put(player, rank-1);
            map.put(beforePlayer, rank);
        }
       
        return players;
    }
}
