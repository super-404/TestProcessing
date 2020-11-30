import processing.core.PImage;

/**
 * @program: TestProcessing
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-23 21:03
 **/
public class Image {
    private final String imgFilePath = "src/main/resource/";
    private String path;
    private int x;
    private int y;
    private PImage pImage;
    private boolean isVisible;
    public void setVisible(boolean f){
        this.isVisible=f;
    }
    public boolean getVisible(){
        return this.isVisible;
    }
    public PImage getpImage() {
        return pImage;
    }

    public void setpImage(PImage pImage) {
        this.pImage = pImage;
    }

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = imgFilePath+path;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Image() {

    }

    public Image(String path, int x, int y) {
        this.path = path;
        this.x = x;
        this.y = y;
    }
}
