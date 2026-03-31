import java.util.Scanner;
class LongestWord{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String sentence=scn.nextLine();
        String longest="";
        String current="";
        for(int index=0;index<=sentence.length();index++){
            if(index==sentence.length()||sentence.charAt(index)==' '){
                if(current.length()>longest.length()){
                    longest=current;
                }
                current="";
            }else{
                current=current+sentence.charAt(index);
            }
        }
        System.out.println("Longest word "+longest);
    }
}
