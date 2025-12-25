import java.util.Scanner;
class CountVowelConsonant{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        String text=scn.nextLine();
        int vowelCount=0;
        int consonantCount=0;
        for(int index=0;index<text.length();index++){
            char ch=text.charAt(index);
            if(ch>='A'&&ch<='Z') ch=(char)(ch+32);
            if(ch>='a'&&ch<='z'){
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    vowelCount++;
                }else{
                    consonantCount++;
                }
            }
        }
        System.out.println("Vowels "+vowelCount);
        System.out.println("Consonants "+consonantCount);
    }
}
