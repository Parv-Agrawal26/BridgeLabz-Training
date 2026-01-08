public class InventoryManagementSystemUsingSingly {
    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();

        inventory.addFirst(new Item("Pen", 101, 50, 10.0));
        inventory.addLast(new Item("Notebook", 102, 20, 45.5));
        inventory.addAtPosition(new Item("Pencil", 103, 100, 5.0), 1);
        inventory.addLast(new Item("Eraser", 104, 40, 3.5));

        System.out.println("Inventory (initial):");
        inventory.display();

        System.out.println("\nSearch by Item ID=102:");
        inventory.searchById(102);

        System.out.println("\nSearch by Item Name='Pencil':");
        inventory.searchByName("Pencil");

        System.out.println("\nUpdate quantity of Item ID=101 to 60:");
        inventory.updateQuantityById(101, 60);

        System.out.println("\nRemove Item ID=104:");
        inventory.removeById(104);

        System.out.println("\nInventory (after updates):");
        inventory.display();

        System.out.println("\nTotal inventory value:");
        System.out.println(inventory.totalValue());

        System.out.println("\nSort by Item Name ascending:");
        inventory.sort(InventoryList.SortKey.NAME, true);
        inventory.display();

        System.out.println("\nSort by Price descending:");
        inventory.sort(InventoryList.SortKey.PRICE, false);
        inventory.display();
    }

    static final class Item {
        final String name;
        final int id;
        int quantity;
        final double price;

        Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
        }

        double value() {
            return price * quantity;
        }
    }

    static final class InventoryList {
        enum SortKey {
            NAME,
            PRICE
        }

        private static final class Node {
            Item data;
            Node next;

            Node(Item data) {
                this.data = data;
            }
        }

        private Node head;

        void addFirst(Item item) {
            Node newNode = new Node(item);
            newNode.next = head;
            head = newNode;
            System.out.println("Item added at beginning");
        }

        void addLast(Item item) {
            Node newNode = new Node(item);
            if (head == null) {
                head = newNode;
                System.out.println("Item added at end");
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            System.out.println("Item added at end");
        }

        void addAtPosition(Item item, int position) {
            if (position <= 0 || head == null) {
                addFirst(item);
                return;
            }

            Node current = head;
            int index = 0;
            while (current.next != null && index < position - 1) {
                current = current.next;
                index++;
            }
            Node newNode = new Node(item);
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Item added at position " + position);
        }

        boolean removeById(int id) {
            if (head == null) {
                System.out.println("Inventory is empty");
                return false;
            }

            if (head.data.id == id) {
                head = head.next;
                System.out.println("Item with ID " + id + " removed");
                return true;
            }

            Node current = head;
            while (current.next != null) {
                if (current.next.data.id == id) {
                    current.next = current.next.next;
                    System.out.println("Item with ID " + id + " removed");
                    return true;
                }
                current = current.next;
            }

            System.out.println("Item with ID " + id + " not found");
            return false;
        }

        boolean updateQuantityById(int id, int newQuantity) {
            Node node = findById(id);
            if (node == null) {
                System.out.println("Item with ID " + id + " not found");
                return false;
            }
            node.data.quantity = newQuantity;
            System.out.println("Quantity updated for ID " + id);
            return true;
        }

        void searchById(int id) {
            Node node = findById(id);
            if (node == null) {
                System.out.println("Item with ID " + id + " not found");
                return;
            }
            printItem(node.data);
        }

        void searchByName(String name) {
            Node current = head;
            while (current != null) {
                if (current.data.name.equalsIgnoreCase(name)) {
                    printItem(current.data);
                    return;
                }
                current = current.next;
            }
            System.out.println("Item with name '" + name + "' not found");
        }

        double totalValue() {
            double total = 0.0;
            Node current = head;
            while (current != null) {
                total += current.data.value();
                current = current.next;
            }
            return total;
        }

        void sort(SortKey key, boolean ascending) {
            head = mergeSort(head, key, ascending);
            System.out.println("Inventory sorted by " + key + " (" + (ascending ? "ASC" : "DESC") + ")");
        }

        void display() {
            if (head == null) {
                System.out.println("Inventory is empty");
                return;
            }

            Node current = head;
            while (current != null) {
                printItem(current.data);
                current = current.next;
            }
        }

        private Node findById(int id) {
            Node current = head;
            while (current != null) {
                if (current.data.id == id) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        private static void printItem(Item item) {
            System.out.println(
                    "Item: " + item.name + ", ID: " + item.id + ", Qty: " + item.quantity + ", Price: " + item.price
                            + ", Value: " + item.value());
        }

        private static Node mergeSort(Node start, SortKey key, boolean ascending) {
            if (start == null || start.next == null) {
                return start;
            }

            Node middle = splitMiddle(start);
            Node right = middle.next;
            middle.next = null;

            Node leftSorted = mergeSort(start, key, ascending);
            Node rightSorted = mergeSort(right, key, ascending);
            return merge(leftSorted, rightSorted, key, ascending);
        }

        private static Node splitMiddle(Node start) {
            Node slow = start;
            Node fast = start;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private static Node merge(Node left, Node right, SortKey key, boolean ascending) {
            Node dummy = new Node(new Item("", -1, 0, 0.0));
            Node tail = dummy;

            while (left != null && right != null) {
                int cmp = compare(left.data, right.data, key);
                if (!ascending) {
                    cmp = -cmp;
                }

                if (cmp <= 0) {
                    tail.next = left;
                    left = left.next;
                } else {
                    tail.next = right;
                    right = right.next;
                }
                tail = tail.next;
                tail.next = null;
            }

            tail.next = (left != null) ? left : right;
            return dummy.next;
        }

        private static int compare(Item a, Item b, SortKey key) {
            if (key == SortKey.PRICE) {
                return Double.compare(a.price, b.price);
            }
            return a.name.compareToIgnoreCase(b.name);
        }
    }
}
