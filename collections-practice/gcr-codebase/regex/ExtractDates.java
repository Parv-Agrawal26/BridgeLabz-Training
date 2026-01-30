import java.util.regex.*;

class ExtractDates {
    public static void main(String[] args) {
        String text = "Dates are 12/05/2023, 15/08/2024 and 29/02/2020";

        Pattern p = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
