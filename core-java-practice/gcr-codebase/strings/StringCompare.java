import java.util.Scanner;
class StringCompare{
    static boolean compareStrings(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String str1=scn.next();
        String str2=scn.next();
        boolean resultByChar=compareStrings(str1,str2);
        boolean resultByEquals=str1.equals(str2);
        System.out.println("Result using charAt is "+resultByChar);
        System.out.println("Result using equals is "+resultByEquals);
        if(resultByChar==resultByEquals){
            System.out.println("Both results are same");
        }else{
            System.out.println("Results are not same");
        }
    }
}
