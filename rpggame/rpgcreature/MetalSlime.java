package rpgcreature;

import java.util.Random;

/**
 * メタルスライムクラス
 */
public class MetalSlime extends Monster{
    private final static int ESCAPE_RATE = 40;
    private final static int METAL_SLIME_HP=12;
    private final int DAMAGE_MAX=5;
    /**
     * メタルスライムのコンストラクタ
     */
    public MetalSlime(){
        super("メタルスライム",METAL_SLIME_HP);
    }

    /**
     * 攻撃メソッド
     * @param opponent：攻撃相手
     */
    @Override
    public void attack(Creature opponent) {
        if(isThere()){
            Random r = new Random();
            if( r.nextInt(PERSENT) < ESCAPE_RATE ){
                System.out.printf("%sは逃げ出した！\n",getName());
                escapeFlag = true;
            }else{
                int damage = r.nextInt(DAMAGE_MAX);
                System.out.printf("%sの攻撃！\n",getName());
            
                opponent.damaged(damage);
            
                displayMessage(opponent,damage);
            }
        }
    }
}
