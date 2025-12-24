import java.util.Scanner;

class WindChillCalc {
    static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        double temperature = scn.nextDouble();
        double windSpeed = scn.nextDouble();
        double result = calculateWindChill(temperature, windSpeed);
        System.out.println("Wind chill " + result);
    }
}
