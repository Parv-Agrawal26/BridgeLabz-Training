import java.util.Scanner;
class ReverseString{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        String reversed="";
        for(int index=text.length()-1;index>=0;index--){
            reversed=reversed+text.charAt(index);
        }
        System.out.println("Reversed String "+reversed);
    }
}
