
import processing.core.PApplet;
public class Main extends PApplet {
    int x,s;

   public void settings()
    {
        size(666,666);
    }

    public void draw()
    {
        background(64);
        rect(256, 554 , 28,28);
        rect(280, 532 , 28,28);
    }
    public static void main(String[] args) {
        String[] appletArgs = new String[] { "Main" };
        PApplet.main(appletArgs);
    }
}
