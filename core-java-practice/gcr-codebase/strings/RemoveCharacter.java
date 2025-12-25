import java.util.Scanner;
class RemoveCharacter{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        char remove=scn.next().charAt(0);
        String result="";
        for(int index=0;index<text.length();index++){
            if(text.charAt(index)!=remove){
                result=result+text.charAt(index);
            }
        }
        System.out.println("Modified String "+result);
    }
}
