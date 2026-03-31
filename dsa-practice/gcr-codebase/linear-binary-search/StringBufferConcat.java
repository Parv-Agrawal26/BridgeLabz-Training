public class StringBufferConcat {

    public static void main(String[] args) {

        String[] words = {"Java", " ", "is", " ", "easy"};

        StringBuffer buffer = new StringBuffer();

        for (int index = 0; index < words.length; index++) {
            buffer.append(words[index]);
        }

        System.out.println(buffer.toString());
    }
}
