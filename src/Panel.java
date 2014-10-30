import javax.swing.*;
import java.awt.*;

/**
 * Created by tom on 30/10/2014.
 */
public class Panel extends JPanel {
    private int x1, x2, y1, y2;
    public Panel(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(0x273E96));
        g.fillRect(0, 0, 640, 480);
        g.setColor(new Color(0x319649));
        g.drawLine(x1,x2,y1,y2);
    }
}
