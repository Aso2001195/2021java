package rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class Golem extends Monster{
    private final static int CRITICAL_HIT_RATE=5;
    private final static int GOLEM_HP=100;
    private final int NOMAL_DAMEG_MAX=10;
    private final int NOMAL_DAMEG_MIN=5;
    private final int CRITICAL_DAMEG=10;
    /**
     * メタルスライムのコンストラクタ
     */
    public Golem(){
        super("ゴーレム",GOLEM_HP);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        if(isThere()){
            Random r = new Random();
            int damage=r.nextInt(NOMAL_DAMEG_MAX)+NOMAL_DAMEG_MIN;
            if(r.nextInt(PERSENT)<CRITICAL_HIT_RATE){
                damage=CRITICAL_DAMEG;
            }
            System.out.printf("%sの攻撃！\n",getName());
        
            opponent.damaged(damage);
        
            displayMessage(opponent,damage);
        }
    }
}
