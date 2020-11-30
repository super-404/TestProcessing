
import processing.core.PApplet;
import processing.core.PImage;

import java.util.*;

/**
 * @program: TestProcessing
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-23 09:18
 **/

public class PACMANDoodle extends PApplet {
    PImage image;
    Map map = new Map ();
    List<Ghost> lg;
    List<Fruit> lf;
    List<Wall> lw;
    Waka w;
    String path = "playerClosed.png";
    String defaultPath = "playerClosed.png";
    final int width = 784;//556
    final int height = 1008;//
    boolean flag = false;
    final int size = 16;
    //左，上，右，下
    boolean direction[] = {false, false, false, false};
    public void settings() {
        size (width, height);
        List<Image> li = map.getLp ();
        //鬼魂
        lg = map.getLg ();
        //waka
        w = map.getWaka ();
        //水果
        lf = map.getLf ();
        //墙
        lw = map.getLw ();
        //处理墙
        for (Wall w : lw) {
            Image img = w.getImage ();
            //因为有可能出现空的路径，所以需要判断一下
            if (img.getPath ().lastIndexOf (".") != -1) {
                //包装成PImage
                image = loadImage (img.getPath ());
                if(img.getVisible ()) {
                    img.setpImage (image);
                }
            }
        }
        //处理水果
        for (Fruit f : lf) {
            Image img = f.getImage ();
            //包装成PImage
            if(img.getVisible ()) {
                image = loadImage (img.getPath ());
                img.setpImage (image);
            }
        }
        //处理ghost
        for (Ghost g : lg) {
            Image img = g.getImage ();
            if(img.getVisible ()) {
                image = loadImage (g.getImage ().getPath ());
                g.getImage ().setpImage (image);
            }
        }
        Image wakaImage = w.getImage ();
        //处理Waka
        image = loadImage (wakaImage.getPath ());
        //  System.out.println ("f(" + w.getImage ().getX () + "," + w.getImage ().getY () + ")");
       wakaImage.setpImage (image);
    }

    public void draw() {
        frameRate (15);
        background (64);
        Image wakaImage = w.getImage ();
        keyPressed ();
        keyReleased ();
        move (wakaImage);
        eat(wakaImage);
        if (!flag) {
            wakaImage.setPath (defaultPath);
            flag = true;
        } else {
            wakaImage.setPath (path);
            flag = false;
        }
        //水果
        for (Fruit f : lf) {
            Image image=f.getImage ();
            if(image.getVisible ()){
                image (image.getpImage (), image.getX (), image.getY ());
            }
        }
        //墙
        for (Wall w : lw) {
            Image image=w.getImage ();
            if(image.getVisible ()&&image.getPath ().lastIndexOf (".") != -1){
                image (image.getpImage (), image.getX (), image.getY ());
            }
        }
        //ghost
        for (Ghost g : lg) {
            Image i = g.getImage ();
            image (i.getpImage (), i.getX (), i.getY ());
        }
        //player
        image = loadImage (wakaImage.getPath ());
        wakaImage.setpImage (image);
        image (wakaImage.getpImage (), wakaImage.getX (), wakaImage.getY ());
    }
    public void eat(Image wakaImage){
        int wx=wakaImage.getX ();
        int wy=wakaImage.getY();
        for(Fruit f:lf){
            Image ig=f.getImage ();
            if(checkedCollision (wx,wy,ig,size)){
                ig.setVisible (false);
            }
        }
    }
    boolean checkedCollision(int x ,int y,Image i,int size){
        boolean collisionX=x+size>i.getX ()&&i.getX ()+size>x;
        boolean collisionY=y+size>i.getY ()&&i.getY ()+size>y;
        return collisionX&&collisionY;
    }
    public void move(Image wakaImage) {
        int size=16;
       boolean flag=true;
        //左
        int wx=0;
        int wy=0;
        if (direction[0]) {
            int x = wakaImage.getX () - w.getSpeed ();
            int y = wakaImage.getY ();
            for(Wall w:lw){
                Image i=w.getImage ();
                if(checkedCollision (x,y,i,size)) {
                    flag = false;
                    wx = i.getX ();
                    wy = i.getY ();
                    break;
                }
            }
            if(flag){
                wakaImage.setX (x);
            }else{
                System.out.println ("相撞"+"玩家："+"("+x+","+y+")");
                System.out.println ("相撞"+"墙："+"("+wx+","+wy+")");
            }
        }
        //上
        if (direction[1]) {
            int x = wakaImage.getX ();
            int y = wakaImage.getY () - w.getSpeed ();
            for(Wall w:lw){
                Image i=w.getImage ();
                if(checkedCollision (x,y,i,size)){
                    flag=false;
                    wx=i.getX ();
                    wy=i.getY ();
                    break;
                }
            }
            if(flag){
                wakaImage.setY (y);
            }
            else{
                System.out.println ("相撞"+"玩家："+"("+x+","+y+")");
                System.out.println ("相撞"+"墙："+"("+wx+","+wy+")");
            }
        }
        //右
        if (direction[2]) {
            int x = wakaImage.getX () + w.getSpeed ();
            int y = wakaImage.getY ();
            for(Wall w:lw){
                Image i=w.getImage ();
                if(checkedCollision (x,y,i,size)){
                    flag=false;
                    wx=i.getX ();
                    wy=i.getY ();
                    break;
                }
            }
            if(flag){
                wakaImage.setX (x);
            }
            else{
                System.out.println ("相撞"+"玩家："+"("+x+","+y+")");
                System.out.println ("相撞"+"墙："+"("+wx+","+wy+")");
            }
        }
        //下
        if (direction[3]) {
            int x = wakaImage.getX ();
            int y = wakaImage.getY () + w.getSpeed ();
            for(Wall w:lw){
                Image i=w.getImage ();
                if(checkedCollision (x,y,i,size)){
                    flag=false;
                    wx=i.getX ();
                    wy=i.getY ();
                    break;
                }
            }
            if(flag){
                wakaImage.setY (y);
            }
            else{
                System.out.println ("相撞"+"玩家："+"("+x+","+y+")");
                System.out.println ("相撞"+"墙："+"("+wx+","+wy+")");
            }
        }
    }

    public void keyReleased() {

    }

    public void keyPressed() {
        if (keyPressed) {
            if (keyCode == 37) {
                path = "playerLeft.png";
                Arrays.fill (direction, false);
                direction[0] = true;
            }
            if (keyCode == 38) {
                path = "playerUp.png";
                Arrays.fill (direction, false);
                direction[1] = true;
            }
            if (keyCode == 39) {
                path = "playerRight.png";
                Arrays.fill (direction, false);
                direction[2] = true;
            }
            if (keyCode == 40) {
                path = "playerDown.png";
                Arrays.fill (direction, false);
                direction[3] = true;
            }
        }
//        System.out.println (keyCode);
    }

    public static void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"PACMANDoodle"};
        PApplet.main (appletArgs);
    }
}
