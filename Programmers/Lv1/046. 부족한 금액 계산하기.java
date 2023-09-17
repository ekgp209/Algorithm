package Lv1;

class Solution {
    public long solution(int price, int money, int count) {
        long tot_money = 0;

        for(int i=1; i<=count; i++){
            long now_money = price*i;
            tot_money += now_money;
        }

        return (money - tot_money >= 0) ? 0 : tot_money - money;
    }
}