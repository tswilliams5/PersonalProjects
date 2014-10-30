/**
 * Created by tom on 30/10/2014.
 */
public class Plot {

    private double damage; //in £
    private double distance; //this is the distance from the nearest fire station in miles

    static Double coefficient = 0.0;
    static Double constant = 0.0;

    public static double predictDamage(double distance) {
        double damage;
        damage = constant + coefficient*distance;
        return damage;
    }

    public static double predictDistance(double damage) {
        double distance;
        distance = (damage-constant)/coefficient;
        return distance;
    }
    public static void createRegressionModel(Plot[] plots) {
        double sumXY = 0;
        double sumX = 0;
        double sumY = 0;
        double sumXSq = 0;
        double numerator;
        double denominator;
        int n = plots.length;
        for(int i = 0;i<plots.length;i++) {
            sumXY = sumXY + (plots[i].getDamage() * plots[i].getDistance());
            sumX = sumX + plots[i].getDistance();
            sumY = sumY + plots[i].getDamage();
            sumXSq = sumXSq + Math.pow(plots[i].getDistance(),2);
        }

        numerator = sumXY - ((sumX*sumY)/n);
        denominator = sumXSq - (Math.pow(sumX,2)/n);

        coefficient = numerator/denominator;
        constant = (sumY-(coefficient*sumX))/n;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}



//Recalling some 2nd year stats I will use the lease squares method