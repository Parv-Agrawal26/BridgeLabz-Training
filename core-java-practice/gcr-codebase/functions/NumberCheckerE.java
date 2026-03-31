class NumberCheckerE {
    static int sumDivisors(int number) {
        int sum = 0;
        for (int index = 1; index < number; index++) {
            if (number % index == 0)
                sum = sum + index;
        }
        return sum;
    }

    static boolean isPerfect(int number) {
        return sumDivisors(number) == number;
    }

    static boolean isAbundant(int number) {
        return sumDivisors(number) > number;
    }

    static boolean isDeficient(int number) {
        return sumDivisors(number) < number;
    }

    static int fact(int value) {
        int result = 1;
        for (int index = 1; index <= value; index++) {
            result = result * index;
        }
        return result;
    }

    static boolean isStrong(int number) {
        int temp = number;
        int sum = 0;
        while (temp != 0) {
            sum = sum + fact(temp % 10);
            temp = temp / 10;
        }
        return sum == number;
    }
}
