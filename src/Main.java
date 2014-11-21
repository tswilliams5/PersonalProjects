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
      Plot[] plot1 = new Plot[5];

      for(int i = 0;i<5;i++) {
        plot1[i] = new Plot();
      }

      plot1[0].setDistance(1);
      plot1[1].setDistance(3);
      plot1[2].setDistance(5);
      plot1[3].setDistance(1);
      plot1[4].setDistance(6);

      plot1[0].setDamage(15);
      plot1[1].setDamage(14);
      plot1[2].setDamage(5);
      plot1[3].setDamage(6);
      plot1[4].setDamage(1);

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

      //Plot.createRegressionModel(plot);
      Plot.createRegressionModel(plot1);

      System.out.println("Your regression model is: y = " + Plot.coefficient + "x + " + Plot.constant + ".");
      System.out.println("If the distance is 8, then the damage is: " + Plot.predictDamage(8) + "\nand if the damage is 11, then the distance is: " + Plot.predictDistance(11));

      double y1 = 32*Plot.predictDamage(0);
      double y2 = 32*Plot.predictDamage(8);



      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(640, 500);
      window.add(new Panel(15,480 - (int) (32*Plot.predictDamage(0)),8*80,480 - (int) (32*Plot.predictDamage(8)),plot1)); //x1,480 -y1,x2, 480-y2
      window.setVisible(true);
    }
}
