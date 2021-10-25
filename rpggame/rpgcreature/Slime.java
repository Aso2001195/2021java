package rpgcreature;

import java.util.Random;

/**
 * スライムクラス
 */
public class Slime extends Monster{
    private static final int SLIME_HP=12;
    private final int DAMAGE_MAX=5;
    /**
     * スライムクラスのコンストラクタ
     */
    public Slime(){
        super("スライム",SLIME_HP);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        if(isThere()){
            Random r = new Random();
            int damage = r.nextInt(DAMAGE_MAX);
            System.out.printf("%sの攻撃！\n",getName());
        
            opponent.damaged(damage);
        
            displayMessage(opponent,damage);
        }
    }
    
}
