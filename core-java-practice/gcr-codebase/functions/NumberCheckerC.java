class NumberCheckerC {
    static int[] reverse(int[] digits) {
        int[] rev = new int[digits.length];
        for (int index = 0; index < digits.length; index++) {
            rev[index] = digits[digits.length - 1 - index];
        }
        return rev;
    }

    static boolean compare(int[] first, int[] second) {
        if (first.length != second.length)
            return false;
        for (int index = 0; index < first.length; index++) {
            if (first[index] != second[index])
                return false;
        }
        return true;
    }

    static boolean isPalindrome(int[] digits) {
        return compare(digits, reverse(digits));
    }
}
