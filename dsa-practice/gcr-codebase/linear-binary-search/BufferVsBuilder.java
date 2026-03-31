public class BufferVsBuilder {

    public static void main(String[] args) {

        long start1 = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            builder.append("hello");
        }
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            buffer.append("hello");
        }
        long end2 = System.nanoTime();

        System.out.println("StringBuilder Time: " + (end1 - start1));
        System.out.println("StringBuffer Time: " + (end2 - start2));
    }
}
