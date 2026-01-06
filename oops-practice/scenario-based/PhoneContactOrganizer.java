import java.util.*;

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}

public class PhoneContactOrganizer {

    static List<Contact> contactList = new ArrayList<>();

    static void validatePhone(String phone) throws InvalidPhoneNumberException {
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }
    }

    static boolean isDuplicate(String phone) {
        for (Contact contact : contactList) {
            if (contact.phone.equals(phone)) {
                return true;
            }
        }
        return false;
    }

    static void addContact(String name, String phone) throws InvalidPhoneNumberException {
        validatePhone(phone);
        if (isDuplicate(phone)) {
            System.out.println("Duplicate contact not allowed");
            return;
        }
        contactList.add(new Contact(name, phone));
        System.out.println("Contact added");
    }

    static void searchContact(String keyword) {
        for (Contact contact : contactList) {
            if (contact.name.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(contact.name + " - " + contact.phone);
            }
        }
    }

    static void deleteContact(String phone) {
        Iterator<Contact> iterator = contactList.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.phone.equals(phone)) {
                iterator.remove();
                System.out.println("Contact deleted");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            addContact("Ravi", "9876543210");
            addContact("Amit", "9123456789");
            searchContact("ra");
            deleteContact("9123456789");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
