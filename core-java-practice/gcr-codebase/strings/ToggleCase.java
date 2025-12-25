import java.util.Scanner;
class ToggleCase{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        String result="";
        for(int index=0;index<text.length();index++){
            char ch=text.charAt(index);
            if(ch>='A'&&ch<='Z'){
                result=result+(char)(ch+32);
            }else if(ch>='a'&&ch<='z'){
                result=result+(char)(ch-32);
            }else{
                result=result+ch;
            }
        }
        System.out.println("Result "+result);
    }
}
