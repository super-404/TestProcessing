import processing.core.PApplet;
import processing.core.PImage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: TestProcessing
 * @description: 生成背景地图
 * @author: 饶嘉伟
 * @create: 2020-11-23 19:34
 **/
public class Map {

    private List<Image> lp;
    private final String mapFilePath = "src/map.txt";
    private List<String> content;
    private List<Ghost> lg;
    private List<Wall> lw;
    private Waka waka;
    private List<Fruit> lf;
    private int size=26;

    public List<Wall> getLw() {
        return lw;
    }

    public List<Fruit> getLf() {
        return lf;
    }

    public Map() {
        lp = new ArrayList ();
        content = new ArrayList ();
        lg=new ArrayList<> ();
        waka=new Waka();
        lw=new ArrayList<> ();
        lf=new ArrayList<> ();
        generateMap ();
    }

    public List<Ghost> getLg() {
        return lg;
    }

    public Waka getWaka() {
        return waka;
    }

    public List<Image> getLp() {
        return lp;
    }

    void readMap() {
        try {
            BufferedReader br = new BufferedReader (new FileReader (new File (mapFilePath)));
            String line = "";
            while ((line = br.readLine ()) != null) {
                content.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println ("无该文件");
        } catch (IOException e) {
            System.out.println ("IO异常");
        }
    }
    void generateMap(){
        readMap ();
        for(int j=0;j<content.size ();j++){
           String s = content.get(j);
            for(int i=0;i<s.length ();i++) {
                char num = s.charAt (i);
                String path = "";
                Image image = new Image ();
                boolean flag = false;
                switch (num) {
                    case '1': {
                        path =  "horizontal.png";
                        break;
                    }
                    case '2': {
                        path = "vertical.png";
                        break;
                    }
                    case '3': {
                        path = "upLeft.png";
                        break;
                    }
                    case '4': {
                        path =  "upRight.png";
                        break;
                    }
                    case '5': {
                        path ="downLeft.png";
                        break;
                    }
                    case '6': {
                        path = "downRight.png";
                        break;
                    }
                    case '7': {
                        flag = true;
                        path =  "fruit.png";
                        image.setPath (path);
                        image.setX (i * size);
                        image.setY (j * size);
                        image.setVisible (true);
                        Fruit f=new Fruit(true,image);
                        lf.add(f);
                        break;
                    }
                    //这里因为玩家的图像大小不匹配，因此需要单独设置做了点小改动
                    case 'p': {
                        flag = true;
                        path = "playerClosed.png";
                        image.setPath (path);
                        image.setX (i * size);
                        image.setY (j * size);
                        image.setVisible (true);
                        waka.setImage (image);
                        waka.setSpeed (6);
                        break;
                    }
                    //这里因为小鬼的图像大小不匹配，因此需要单独设置做了点小改动
                    case 'g': {
                        flag = true;
                        path =  "ghost.png";
                        image.setPath (path);
                        image.setX (i * size);
                        image.setY (j * size);
                        image.setVisible (true);
                        Ghost g = new Ghost (image,3);
                        lg.add(g);
                        break;
                    }
                }
                if (!flag) {
                    image.setPath (path);
                    image.setX (i * size);
                    image.setY (j * size);
                    image.setVisible (true);
                    Wall w=new Wall(image,size);
                    lw.add(w);
                }
            }
        }
    }
}
