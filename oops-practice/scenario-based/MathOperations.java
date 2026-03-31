class MathOperations {
    static int factorial(int number) {
        if (number < 0) {
            return -1;
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int gcd(int a, int b) {
        if (a < 0)
            a = -a;
        if (b < 0)
            b = -b;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        int first = 0;
        int second = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of -3: " + factorial(-3));
        System.out.println("Is 7 prime: " + isPrime(7));
        System.out.println("Is 1 prime: " + isPrime(1));
        System.out.println("GCD of 12 and 18: " + gcd(12, 18));
        System.out.println("GCD of -10 and 5: " + gcd(-10, 5));
        System.out.println("Fibonacci of 6: " + fibonacci(6));
        System.out.println("Fibonacci of 0: " + fibonacci(0));
    }
}
