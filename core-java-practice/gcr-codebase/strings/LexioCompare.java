import java.util.Scanner;
class LexioCompare{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String first=scn.next();
        String second=scn.next();
        int minLen=first.length()<second.length()?first.length():second.length();
        int result=0;
        for(int index=0;index<minLen;index++){
            if(first.charAt(index)!=second.charAt(index)){
                result=first.charAt(index)-second.charAt(index);
                break;
            }
        }
        if(result==0){
            result=first.length()-second.length();
        }
        if(result<0){
            System.out.println(first+" comes before "+second);
        }else if(result>0){
            System.out.println(second+" comes before "+first);
        }else{
            System.out.println("Both strings are equal");
        }
    }
}
