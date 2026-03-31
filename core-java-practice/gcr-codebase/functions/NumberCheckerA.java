class NumberCheckerA {
    static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    static int[] storeDigits(int number) {
        int size = countDigits(number);
        int[] digits = new int[size];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }
        return digits;
    }

    static boolean isDuck(int[] digits) {
        for (int index = 0; index < digits.length; index++) {
            if (digits[index] == 0)
                return true;
        }
        return false;
    }

    static boolean isArmstrong(int number, int[] digits) {
        int power = digits.length;
        int sum = 0;
        for (int index = 0; index < digits.length; index++) {
            sum = sum + (int) Math.pow(digits[index], power);
        }
        return sum == number;
    }

    static int[] largestSecond(int[] digits) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int index = 0; index < digits.length; index++) {
            if (digits[index] > first) {
                second = first;
                first = digits[index];
            } else if (digits[index] > second) {
                second = digits[index];
            }
        }
        return new int[] { first, second };
    }

    static int[] smallestSecond(int[] digits) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int index = 0; index < digits.length; index++) {
            if (digits[index] < first) {
                second = first;
                first = digits[index];
            } else if (digits[index] < second) {
                second = digits[index];
            }
        }
        return new int[] { first, second };
    }
}
