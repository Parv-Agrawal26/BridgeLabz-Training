import java.util.Scanner;

class FriendsCompare {
    static int youngest(int[] age) {
        int index = 0;
        for (int i = 1; i < age.length; i++) {
            if (age[i] < age[index])
                index = i;
        }
        return index;
    }

    static int tallest(double[] height) {
        int index = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[index])
                index = i;
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] age = new int[3];
        double[] height = new double[3];
        for (int i = 0; i < 3; i++) {
            age[i] = scn.nextInt();
            height[i] = scn.nextDouble();
        }
        System.out.println("Youngest " + names[youngest(age)]);
        System.out.println("Tallest " + names[tallest(height)]);
    }
}
