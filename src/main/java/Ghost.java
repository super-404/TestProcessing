/**
 * @program: TestProcessing
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-24 09:10
 **/
public class Ghost {
    private  Image image;
    private int speed;

    public Ghost(){

    }
    public Ghost(Image image, int speed) {
        this.image = image;
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
