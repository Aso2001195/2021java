package rpgcreature;

import java.util.Random;

/**
 * 魔法使いクラス
 */
public class Wizard extends Monster{
    private static final int WIZARD_HP=30;
    private final int MAGIC_DAMAGE_MAX=10;
    private final int MAGIC_DAMAGE_MIN=5;
    private final int DAMAGE_MAX=5;
    private final int DAMAGE_MIN=1;
    private final int MAGIC_ATTACK_RETE=70;
    /**
     * 魔法使いのコンストラクタ
     */
    public Wizard(){
        super("魔法使い",WIZARD_HP);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
       if(isAlive()) {
            Random r = new Random();
            int damage = 0;
            if( r.nextInt(PERSENT) < MAGIC_ATTACK_RETE){
                System.out.printf("%sは魔法を唱えた！\n",getName());
                damage = r.nextInt(MAGIC_DAMAGE_MAX)+MAGIC_DAMAGE_MIN;
            }else{
                System.out.printf("%sの攻撃！\n",getName());
                damage = r.nextInt(DAMAGE_MAX)+DAMAGE_MIN;
            }
            opponent.damaged(damage);
        
            displayMessage(opponent,damage);
        }
        
    }
}
