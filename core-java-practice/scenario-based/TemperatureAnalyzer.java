public class TemperatureAnalyzer {
    
    public static void analyzeTemperature(float[][] temperatures) {
        if (temperatures == null || temperatures.length != 7) {
            System.out.println("Invalid temperature data");
            return;
        }
        
        float hottestTemp = Float.MIN_VALUE;
        float coldestTemp = Float.MAX_VALUE;
        int hottestDay = 0, coldestDay = 0;
        
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        
        for (int day = 0; day < 7; day++) {
            float daySum = 0;
            
            for (int hour = 0; hour < 24; hour++) {
                float temp = temperatures[day][hour];
                daySum += temp;
                
                if (temp > hottestTemp) {
                    hottestTemp = temp;
                    hottestDay = day;
                }
                
                if (temp < coldestTemp) {
                    coldestTemp = temp;
                    coldestDay = day;
                }
            }
            
            float dayAverage = daySum / 24;
            System.out.print("Average temperature of"+(day+1)+"is "+dayAverage);
        }
        
        System.out.println("Hottest temperature: " + hottestTemp + " on " + days[hottestDay]);
        System.out.println("Coldest temperature: " + coldestTemp + " on " + days[coldestDay]);
    }
    
    public static void main(String[] args) {
        float[][] temperatures = new float[7][24];
        
        for (int day = 0; day < 7; day++) {
            for (int hour = 0; hour < 24; hour++) {
                temperatures[day][hour] = 15 + (float)(Math.random() * 20);
            }
        }
        
        temperatures[2][14] = 38.5f;
        temperatures[5][4] = 8.2f;
        
        analyzeTemperature(temperatures);
    }
}