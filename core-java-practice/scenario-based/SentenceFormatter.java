import java.util.Scanner;
public class SentenceFormatter {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.nextLine();
        text=text.trim();
        StringBuilder sb = new StringBuilder();
        char firstChar = text.charAt(0);
        if((int)firstChar>=97) firstChar = (char)((int)firstChar-32);
        sb.append(firstChar);
        for(int i=1; i<text.length(); i++){
            if(text.charAt(i)==' ' && text.charAt(i-1)==' '){
                continue;
            }
            else if((text.charAt(i-1)=='!' || text.charAt(i-1)=='.' || text.charAt(i)=='?') && text.charAt(i)!=' '){
                sb.append(' ');
                sb.append(Character.toUpperCase(text.charAt(i)));
            }
            else{
                sb.append(text.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
