public class PalindromeChecker {
    private String text;
    private boolean isPalindrome = true;
    PalindromeChecker(String text) {
        this.text = text;
    }
    public void checkPalindrome() {
        int st=0;
        int end=text.length()-1;
        
        while(st<end) {
            if(text.charAt(st)!=text.charAt(end)) {
                isPalindrome=false;
                break;
            }
            st++;
            end--;
        }
    }
    public void printResult() {
        if(isPalindrome) {
            System.out.println(text + " is a palindrome.");
        } else {
            System.out.println(text + " is not a palindrome.");
        }
    }
    public static void main(String[] args) {
        PalindromeChecker pc1 = new PalindromeChecker("madam");
        pc1.checkPalindrome();
        pc1.printResult();

        PalindromeChecker pc2 = new PalindromeChecker("hello");
        pc2.checkPalindrome();
        pc2.printResult();
    }

}
