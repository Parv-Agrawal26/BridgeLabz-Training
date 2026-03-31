import java.util.*;

public class CafeteriaMenuApp {

    static String[] menuItems = {
            "Idli", "Dosa", "Vada", "Upma", "Pongal",
            "Sandwich", "Burger", "Pizza", "Pasta", "Coffee"
    };

    static void displayMenu() {
        System.out.println("Cafeteria Menu:");
        for (int index = 0; index < menuItems.length; index++) {
            System.out.println(index + " - " + menuItems[index]);
        }
    }

    static String getItemByIndex(int index) {
        if (index < 0 || index >= menuItems.length) {
            return "Invalid selection";
        }
        return menuItems[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu();

        System.out.print("Select item index: ");
        int choice = scanner.nextInt();

        String selectedItem = getItemByIndex(choice);
        System.out.println("You selected: " + selectedItem);
    }
}
