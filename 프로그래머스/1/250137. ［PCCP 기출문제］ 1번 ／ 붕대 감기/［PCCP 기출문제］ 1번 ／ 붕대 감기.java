class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int holdingTime = bandage[0];   //시전 시간
        int healingPerSec = bandage[1]; //초당 회복량
        int addHealth = bandage[2];     //추가 회복량
        int max_health = health;        //최대체력

        int preAttackTime = attacks[0][0];     //직전 공격시간
        
        for(int i=0; i<attacks.length; i++){
            int attackTime = attacks[i][0];     //공격시간
            int damage = attacks[i][1];         //피해량
            
            //System.out.println("i: " + i);
            //System.out.println("직전공격시간: " + preAttackTime);
            //System.out.println("현재공격시간: " + attackTime);
            
            int countTime = 0;
            for(int j=preAttackTime+1; j<attackTime; j++){
                health += healingPerSec;
                //System.out.println("시간: " + j + "초, 현재체력: " + health);
                countTime += 1;
                if(countTime == holdingTime){
                    health += addHealth;
                    countTime = 0;
                }

                if(max_health < health){        //최대 체력을 넘겼을 경우, 최대 체력으로 한계 두기
                    health = max_health;
                }
            }    

            health -= damage;
            
            //체력이 0이하로 죽는다면
            if(health <= 0){
                return -1;
            }
            
            preAttackTime = attackTime;
            //System.out.println("남은체력: " + health); 
        }

        return health;
    }
}