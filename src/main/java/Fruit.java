/**
 * @program: TestProcessing
 * @description:
 * @author: 饶嘉伟
 * @create: 2020-11-24 15:38
 **/
public class Fruit {
    private boolean isVisible;
    private Image image;
    public Fruit(){

    }
    public Fruit(boolean isVisible, Image image) {
        this.isVisible = isVisible;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
