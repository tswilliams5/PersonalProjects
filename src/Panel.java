import javax.swing.*;
import java.awt.*;

/**
 * Created by tom on 30/10/2014.
 */
public class Panel extends JPanel {
    private int x1, y1, x2, y2;
    private Plot[] plot2 = new Plot[5];
    public Panel(int x1, int y1, int x2, int y2,Plot[] plot) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        plot2 = plot;
    }
    //x1,480 -y1,x2, 480-y2    640*480 increments of 80*32
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(0xABFFFF));
        g2.fillRect(0, 0, 640, 480);
        g2.setColor(new Color(0x050096));
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(x1, y1, x2, y2);
        g2.drawLine(15,480-15,560+15+30,480-15); //x axis
        g2.drawLine(560+15+30,480-15,560+15+30-5,480-15-5); //arrow
        g2.drawLine(560+15+30,480-15,560+15+30-5,480-15+5); //arrow

        //the origin is (15,480-15)

        g2.drawLine(15,480-15,15,480-448); //y axis
        g2.drawLine(15,480-448,15-5,480-448+5); //arrow
        g2.drawLine(15,480-448,15+5,480-448+5); //arrow

        g2.setColor(new Color(0x000000));
        g2.drawString("Distance (m)",530,480-10-15); //x axis label
        g2.drawString("Damage (£)",15,480-10-448); //y axis label
        g2.drawString("y = " + Double.toString(Plot.returnCoefficient()) + "x + " + Double.toString(Plot.returnConstant()),450,250);

        g2.drawString("0",5,480 - 5); //origin
        for (int i=1;i<8;i++) {
            g2.drawLine(15+80*i,480-15,15+80*i,480-5);
            g2.drawString("" +i,15+80*i+10,480-2);
        }
        for (int i=1;i<14;i++) {
            if (i % 10 ==0) {
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(15, 480 - 15 - (32 * i), 5, 480 - 15 - (32 * i));
                g2.drawString("" + i, -2, 480 - 18 - (32 * i));
            }else if (i % 5 == 0) {
                g2.setStroke(new BasicStroke(3));
                g2.drawLine(15,480-15-(32*i),5,480-15-(32*i));
                g2.drawString("" + i,4,480-18-(32*i));
            } else {
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(15,480-15-(32*i),10,480-15-(32*i));
            }
        }
        for (Plot plot : plot2) {
            g2.drawLine(80 * (int) plot.getDistance()-3,480 - 32 * (int) plot.getDamage()-3,80*(int) plot.getDistance()+3,480 - 32 * (int) plot.getDamage()+3);
            g2.drawLine(80 * (int) plot.getDistance()-3,480 - 32 * (int) plot.getDamage()+3,80*(int) plot.getDistance()+3,480 - 32 * (int) plot.getDamage()-3);
        }

    }
}
