import java.util.Scanner;
class SubstringCount{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        String sub=scn.nextLine();
        int count=0;
        for(int index=0;index<=text.length()-sub.length();index++){
            boolean match=true;
            for(int j=0;j<sub.length();j++){
                if(text.charAt(index+j)!=sub.charAt(j)){
                    match=false;
                    break;
                }
            }
            if(match){
                count++;
            }
        }
        System.out.println("Occurrences "+count);
    }
}
