import javax.swing.*;

/**
 * Created by tom on 30/10/2014.
 */
public class Main {
    /*
    this project is used to store multiple plots about recent fire incidents which include factors such as damage (£) and distance away from nearest fire station
    the aim is to program a machine to spot a correlation
     */
    public static void main(String[] args) {
        System.out.println("Let's begin");

        Plot[] plot = new Plot[5];

        for(int i = 0;i<5;i++) {
            plot[i] = new Plot();
        }

        plot[0].setDistance(1);
        plot[1].setDistance(3);
        plot[2].setDistance(5);
        plot[3].setDistance(1);
        plot[4].setDistance(6);

        plot[0].setDamage(5);
        plot[1].setDamage(10);
        plot[2].setDamage(12);
        plot[3].setDamage(4);
        plot[4].setDamage(15);

        Plot.createRegressionModel(plot);
        System.out.println("Your regression model is: y = " + Plot.coefficient + "x + " + Plot.constant + ".");
        System.out.println("If the distance is 8, then the damage is: " + Plot.predictDamage(8) + "\nand if the damage is 11, then the distance is: " + Plot.predictDistance(11));

        double x2 = 80*Plot.predictDamage(0);
        double y2 = 80*Plot.predictDamage(8);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(640, 480);
        window.add(new Panel(0,480 - (int) x2,8*80,480 - (int) y2));
        window.setVisible(true);


    }
}
