class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int[] attack = new int[attacks[attacks.length-1][0]+1];
        for(int i=0; i<attacks.length; i++){
            int attackNumber = attacks[i][0];
            int damage = attacks[i][1];
            attack[attackNumber] = damage;
        }
        // 시전 시간, 초당 회복량, 추가 회복량
        // 최대체력
        // 몬스터 공격 시간과 피해량
        int cnt=0;
        int heal = health;
        for(int i=1; i<attack.length; i++){
            if(attack[i]==0){
                heal= Math.min(health, heal+bandage[1]);
                cnt++;
                if(cnt==bandage[0]){
                    cnt=0;
                    heal= Math.min(health, heal+bandage[2]);
                }
            }else{
                cnt=0;
                heal-=attack[i];
                if(heal<1) return -1;
            }
        }
        return heal;
    }
}