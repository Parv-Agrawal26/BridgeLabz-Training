import java.util.Scanner;
class ReplaceWord{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String sentence=scn.nextLine();
        String oldWord=scn.next();
        String newWord=scn.next();
        String result="";
        String current="";
        for(int index=0;index<=sentence.length();index++){
            if(index==sentence.length()||sentence.charAt(index)==' '){
                if(current.equals(oldWord)){
                    result=result+newWord+" ";
                }else{
                    result=result+current+" ";
                }
                current="";
            }else{
                current=current+sentence.charAt(index);
            }
        }
        System.out.println("Result "+result.trim());
    }
}
