import java.util.Scanner;
class MostFrequentChar{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        int[] freq=new int[256];
        for(int index=0;index<text.length();index++){
            freq[text.charAt(index)]++;
        }
        char mostChar=text.charAt(0);
        int max=freq[mostChar];
        for(int index=0;index<text.length();index++){
            if(freq[text.charAt(index)]>max){
                max=freq[text.charAt(index)];
                mostChar=text.charAt(index);
            }
        }
        System.out.println("Most Frequent Character "+mostChar);
    }
}
