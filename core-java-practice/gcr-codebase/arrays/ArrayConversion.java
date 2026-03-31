import java.util.Scanner;
class ArrayConversion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int rows =scn.nextInt();
        int cols= scn.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j =0; j<cols; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i<rows; i++) {
            for (int j = 0;j < cols;j++) {
                array[index] =matrix[i][j];
                index++;
            }
        }
        for (int i = 0;i <array.length;i++) {
            System.out.println(array[i]);
        }
    }
}
