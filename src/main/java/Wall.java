/**
 * @program: TestProcessing
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-24 15:28
 **/
public class Wall {
    private Image image;
    private int length;

    public Wall(){

    }
    public Wall(Image image, int length) {
        this.image = image;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
