import java.util.Scanner;

class RandomStats {
    static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int) (Math.random() * 9000);
        }
        return arr;
    }

    static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
            min = Math.min(min, numbers[i]);
            max = Math.max(max, numbers[i]);
        }
        return new double[] { sum / (double) numbers.length, min, max };
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int size = scn.nextInt();
        int[] arr = generate4DigitRandomArray(size);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        double[] result = findAverageMinMax(arr);
        System.out.println("Average " + result[0]);
        System.out.println("Min " + result[1]);
        System.out.println("Max " + result[2]);
    }
}
