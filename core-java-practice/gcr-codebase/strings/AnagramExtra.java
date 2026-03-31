import java.util.Scanner;
class AnagramExtra{
    static boolean isAnagram(String first,String second){
        if(first.length()!=second.length()) return false;
        int[] freq=new int[256];
        for(int index=0;index<first.length();index++){
            freq[first.charAt(index)]++;
            freq[second.charAt(index)]--;
        }
        for(int i=0;i<256;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String first=scn.next();
        String second=scn.next();
        System.out.println("Anagram "+isAnagram(first,second));
    }
}
