class NumberCheckerB {
    static int sumDigits(int[] digits) {
        int sum = 0;
        for (int index = 0; index < digits.length; index++) {
            sum = sum + digits[index];
        }
        return sum;
    }

    static double sumSquareDigits(int[] digits) {
        double sum = 0;
        for (int index = 0; index < digits.length; index++) {
            sum = sum + Math.pow(digits[index], 2);
        }
        return sum;
    }

    static boolean isHarshad(int number, int[] digits) {
        int sum = sumDigits(digits);
        return number % sum == 0;
    }

    static int[][] frequency(int[] digits) {
        int[] freq = new int[10];
        for (int index = 0; index < digits.length; index++) {
            freq[digits[index]]++;
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0)
                count++;
        }
        int[][] result = new int[count][2];
        int row = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                result[row][0] = i;
                result[row][1] = freq[i];
                row++;
            }
        }
        return result;
    }
}
