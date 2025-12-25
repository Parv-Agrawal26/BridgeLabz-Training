import java.util.Scanner;
class RemoveDuplicates{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        String result="";
        for(int i=0;i<text.length();i++){
            char current=text.charAt(i);
            boolean found=false;
            for(int j=0;j<result.length();j++){
                if(result.charAt(j)==current){
                    found=true;
                    break;
                }
            }
            if(!found){
                result=result+current;
            }
        }
        System.out.println("Result "+result);
    }
}
