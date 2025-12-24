class NumberCheckerD {
    static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int index = 2; index <= number / 2; index++) {
            if (number % index == 0)
                return false;
        }
        return true;
    }

    static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square != 0) {
            sum = sum + (square % 10);
            square = square / 10;
        }
        return sum == number;
    }

    static boolean isSpy(int number) {
        int sum = 0, product = 1;
        while (number != 0) {
            int digit = number % 10;
            sum = sum + digit;
            product = product * digit;
            number = number / 10;
        }
        return sum == product;
    }

    static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }
}
