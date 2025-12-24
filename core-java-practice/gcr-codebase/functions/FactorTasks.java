class FactorTasks {
    static int[] factors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }
        int[] arr = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                arr[index] = i;
                index++;
            }
        }
        return arr;
    }

    static int greatest(int[] factors) {
        return factors[factors.length - 2];
    }

    static int sum(int[] factors) {
        int total = 0;
        for (int i = 0; i < factors.length; i++)
            total += factors[i];
        return total;
    }

    static long product(int[] factors) {
        long prod = 1;
        for (int i = 0; i < factors.length; i++)
            prod *= factors[i];
        return prod;
    }

    static double cubeProduct(int[] factors) {
        double prod = 1;
        for (int i = 0; i < factors.length; i++) {
            prod *= Math.pow(factors[i], 3);
        }
        return prod;
    }
}
