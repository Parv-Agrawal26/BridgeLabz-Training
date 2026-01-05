import java.util.*;

class InvalidInvoiceFormatException extends Exception {
    InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-") || !input.contains("INR")) {
            throw new InvalidInvoiceFormatException("Invalid invoice format");
        }
        return input.split(",");
    }

    static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");
            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid task entry");
            }

            String amountPart = parts[1].replace("INR", "").trim();
            try {
                total += Integer.parseInt(amountPart);
            } catch (NumberFormatException exception) {
                throw new InvalidInvoiceFormatException("Invalid amount value");
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        String input = scanner.nextLine();

        try {
            String[] tasks = parseInvoice(input);
            int total = getTotalAmount(tasks);

            System.out.println("Invoice Summary:");
            for (String task : tasks) {
                System.out.println(task.trim());
            }
            System.out.println("Total Amount: " + total + " INR");

        } catch (InvalidInvoiceFormatException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
