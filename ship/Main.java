package ship;
import java.util.*;
public class Main {
    public static int shipx=0;
    public static int shipy=0;
    public static int ship2x=0;
    public static int ship2y=0;
    public static int ship3x=0;
    public static int ship3y=0;
    public static int x;
    public static int y;
    public static int id,id2,id3;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Ship ship=new Ship();
        System.out.println("****************************");
        System.out.println("\t戦艦ゲーム\t");
        System.out.println("****************************");
        System.out.print("プレイヤー名:"); 
        String name=scanner.nextLine();
        System.out.println("マップの大きさを設定します。");
        System.out.print("x:"); 
        x=scanner.nextInt();
        ship.mapx=x;
        System.out.print("y:"); 
        y=scanner.nextInt();
        ship.mapy=y;
        int[][] map=new int[x][y];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                map[i][j]=0;
            }
        } 
        int xx=x-1,yy=y-1;
        System.out.println("マップを x:0~"+xx+" y:0~"+yy+"に設定");
        shipx=ship.randomxy(shipx,x);
        shipy=ship.randomxy(shipy,y);
        map[shipx][shipy]=15; //PLAYER
        id=15;
        System.out.println("PLAYER:"+name+"の位置はx座標:"+shipx+" y座標:"+shipy+"です。\n");
        ship2x=ship.randomxy(ship2x,x);
        ship2y=ship.randomxy(ship2y,y);
        /*ship2x=shipx; 
        ship2y=shipy;
        System.out.println("x座標:"+ship2x+" y座標:"+ship2y);*/
        ship.coordinate(shipx, ship2x, shipy, ship2y);

        map[ship2x][ship2y]=5;    //敵艦1
        Ship ship2=new Ship();
        id2=5;
        ship2.name="敵艦1";
        ship2.hp=5;
        System.out.println(ship2x+" "+ship2y);

        ship3x=ship.randomxy(ship3x,x);
        ship3y=ship.randomxy(ship3y,y);
        ship.coordinate(shipx, ship2x, ship3x, shipy, ship2y, ship3y);
        map[ship3x][ship3y]=3;    //敵艦2
        Ship ship3=new Ship();
        id3=3;
        ship3.name="敵艦2";
        ship3.hp=3;
        System.out.println(ship3x+" "+ship3y);

        System.out.println("それでは戦闘を開始する! PLAYER:"+name+"!　貴様には敵艦の迎撃を頼みたい。");
        System.out.println("だが、今はセンサーが壊れてしまい 砲弾が敵艦の近くに落ちたか、当たったかしかわからなくなってしまった。");
        System.out.println("勿論命中したら敵艦は移動してしまう。砲兵としての腕をみしてやれ！\t~Captain Jon~\n");

        System.out.println("\tGAME START!!");
        while(ship2.hp!=0||ship3.hp!=0){
            System.out.println("砲撃する座標を入力");
            System.out.print("x座標:");
            int attackx=scanner.nextInt();
            System.out.print("y座標:");
            int attacky=scanner.nextInt();
            int at=map[attackx][attacky];
            ship.cnt++;

            //GAME OVER
            if(attackx>=x||attacky>=y){
                System.out.println("どこを撃っているんだ！！　貴様はクビだ！！");
                System.out.println("\t~GAME OVER~");
                System.exit(0);
            }else if(at==15){
                System.out.println("おい！こっちは味方だぞ！！！　さては敵艦のスパイだな！！");
                System.out.println("\t~GAME OVER~");
                System.exit(0); 
            }  

            //命中
            if(at==5){
                System.out.println(ship2.name+"に命中！");
                ship2.hp-=1;
                System.out.println("よくやった！！");
                ship.evaluation(ship2.hp, ship3.hp, ship2.name, ship3.name,map[ship2x][ship2y]);
            }else if(at==3){
                System.out.println(ship3.name+"に命中！");
                ship3.hp-=1;
                System.out.println("よくやった！！");
                ship.evaluation(ship2.hp, ship3.hp, ship2.name, ship3.name,map[ship3x][ship3y]);
            }
            
            //波高し
            //四隅
            if(attackx==x-1&&attacky==y-1){      //右上
                if(map[attackx-1][attacky]==id2||map[attackx][attacky-1]==id2){
                    ship.highwaves(id2,ship2.name,ship3.name);
                }
                if(map[attackx-1][attacky]==id3||map[attackx][attacky-1]==id3){
                    ship.highwaves(id3, ship2.name, ship3.name);
                }
            }else if(attackx==0&&attacky==0){  //左下
                if(map[attackx+1][attacky]==id2||map[attackx][attacky+1]==id2){
                    ship.highwaves(id2,ship2.name,ship3.name);
                }
                if(map[attackx+1][attacky]==id3||map[attackx][attacky+1]==id3){
                    ship.highwaves(id3,ship2.name,ship3.name);
                }
            }else if(attackx==0&&attacky==y-1){   //左上
                if(map[attackx+1][attacky]==id2||map[attackx][attacky-1]==id2){
                    ship.highwaves(id2,ship2.name,ship3.name);
                }
                if(map[attackx+1][attacky]==id3||map[attackx][attacky-1]==id3){
                    ship.highwaves(id3,ship2.name,ship3.name);
                }
            }else if(attackx==x-1&&attacky==0){  //右下
                if(map[attackx-1][attacky]==id2||map[attackx][attacky+1]==id2){
                    ship.highwaves(id2,ship2.name,ship3.name);
                }
                if(map[attackx-1][attacky]==id3||map[attackx][attacky+1]==id3){
                    ship.highwaves(id3,ship2.name,ship3.name);
                }
            }else if(attackx!=0&&attackx!=x-1){
                if(attacky==0){
                    if(map[attackx+1][attacky]==id2||map[attackx][attacky+1]==id2||map[attackx-1][attacky]==id2){
                        ship.highwaves(id2,ship2.name,ship3.name);
                    }
                    if(map[attackx+1][attacky]==id3||map[attackx][attacky+1]==id3||map[attackx-1][attacky]==id3){
                        ship.highwaves(id3,ship2.name,ship3.name);
                    }
                }else if(attacky==y-1){
                    if(map[attackx+1][attacky]==id2||map[attackx][attacky-1]==id2||map[attackx-1][attacky]==id2){
                        ship.highwaves(id2,ship2.name,ship3.name);
                    }
                    if(map[attackx+1][attacky]==id3||map[attackx][attacky-1]==id3||map[attackx-1][attacky]==id3){
                        ship.highwaves(id3,ship2.name,ship3.name);
                    }
                }
            }else if(attacky!=0&&attacky!=y-1){
                if(attackx==0){
                    if(map[attackx+1][attacky]==id2||map[attackx][attacky+1]==id2||map[attackx-1][attacky]==id2){
                        ship.highwaves(id2,ship2.name,ship3.name);
                    }
                    if(map[attackx+1][attacky]==id3||map[attackx][attacky+1]==id3||map[attackx-1][attacky]==id3){
                        ship.highwaves(id3,ship2.name,ship3.name);
                    }
                }else if(attackx==x-1){
                    if(map[attackx][attacky+1]==id2||map[attackx][attacky-1]==id2||map[attackx-1][attacky]==id2){
                        ship.highwaves(id2,ship2.name,ship3.name);
                    }
                    if(map[attackx][attacky+1]==id3||map[attackx][attacky-1]==id3||map[attackx-1][attacky]==id3){
                        ship.highwaves(id3,ship2.name,ship3.name);
                    }
                }else{
                    if(map[attackx][attacky+1]==id2||map[attackx][attacky-1]==id2||map[attackx-1][attacky]==id2||map[attackx+1][attacky]==id2){
                        ship.highwaves(id2,ship2.name,ship3.name);
                    }
                    if(map[attackx][attacky+1]==id3||map[attackx][attacky-1]==id3||map[attackx-1][attacky]==id3||map[attackx+1][attacky]==id3){
                        ship.highwaves(id3,ship2.name,ship3.name);
                    }
                }
            }
        }

    }
}
