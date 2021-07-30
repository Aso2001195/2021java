package ship;
import java.util.*;
public class Ship {
    public int mapx,mapy;
    public String name;
    public int hp;
    public int cnt;
    public String evaluation;
    public int randomxy(int xy,int coordinate){
        Random random=new Random();
        /*System.out.println(mapx);
        System.out.println(mapy);*/
        if(coordinate==mapx){
            xy=random.nextInt(mapx);
        }else if(coordinate==mapy){
            xy=random.nextInt(mapy);
        }
        return xy;
    }
    public void coordinate(int shipx,int ship2x,int shipy,int ship2y){
        if(shipx==ship2x&&shipy==ship2y){
            while(shipx==ship2x&&shipy==ship2y){
                Main.ship2x=randomxy(ship2x,mapx);
                Main.ship2y=randomxy(ship2y,mapy);
                //System.out.println("x座標:"+ship2x+" y座標:"+ship2y);
            }
        }
    }
    public void coordinate(int shipx,int ship2x,int ship3x,int shipy,int ship2y,int ship3y){
        if(shipx==ship3x&&shipy==ship3y){
            while(shipx==ship3x&&shipy==ship3y){
                Main.ship3x=randomxy(ship3x,mapx);
                Main.ship3y=randomxy(ship3y,mapy);
                //System.out.println("x座標:"+ship3x+" y座標:"+ship3y);
            }
        }
        if(ship2x==ship3x&&ship2y==ship3y){
            while(ship2x==ship3x&&ship2y==ship3y){
                ship3x=randomxy(ship3x,mapx);
                ship3y=randomxy(ship3y,mapy);
                //System.out.println("x座標:"+ship3x+" y座標:"+ship3y);
            }
        }
    }

    public void evaluation(int hp2,int hp3,String ship2,String ship3,int map){
        if(map==5){
            if(hp2>0){
                System.out.println(ship2+"は移動したぞ！");
                System.out.println("また当ててやれ！！");
                Main.ship2x=randomxy(Main.ship2x,Main.x);
                Main.ship2y=randomxy(Main.ship2y,Main.y);
                coordinate(Main.shipx, Main.ship2x, Main.shipy,Main.ship2y);
            }
        }else if(map==3){
            if(hp3>0){
                System.out.println(ship3+"は移動したぞ！");
                System.out.println("また当ててやれ！！");
                Main.ship3x=randomxy(Main.ship3x,Main.x);
                Main.ship3y=randomxy(Main.ship3y,Main.y);
                coordinate(Main.shipx, Main.ship2x, Main.ship3x, Main.shipy, Main.ship2y, Main.ship3y);
            }
        }
        if(hp2==0&&hp3==0){
            System.out.println("敵艦全て撃沈!!");
            System.out.println(cnt+"発使ったようだな");
            evaluation=evaluation(cnt);
            System.out.println("評価は"+evaluation+"だ！");
        }
    }
    public String evaluation(int cnt){
        if(cnt<15){
            evaluation="S";
        }else if(cnt<20){
            evaluation="A";
        }else if(cnt<25){
            evaluation="B";
        }else{
            evaluation="C";
        }
        return evaluation;
    }
    public void highwaves(int id,String ship2,String ship3){
        if(id==Main.id2){
            System.out.println(ship2+"の近くに着水！    近くにいるぞ!");
        }
        if(id==Main.id3){
            System.out.println(ship3+"の近くに着水！    近くにいるぞ!");
        }
    }
}
