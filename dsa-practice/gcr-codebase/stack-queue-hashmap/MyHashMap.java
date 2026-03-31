public class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table = new Node[10];

    void put(int key, int value) {
        int index = key % table.length;
        Node node = new Node(key, value);

        if (table[index] == null) {
            table[index] = node;
        } else {
            Node temp = table[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    Integer get(int key) {
        int index = key % table.length;
        Node temp = table[index];

        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    void remove(int key) {
        int index = key % table.length;
        Node temp = table[index];
        Node prev = null;

        while (temp != null) {
            if (temp.key == key) {
                if (prev == null) {
                    table[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 100);
        map.put(11, 200); // collision with 1 when table size is 10

        System.out.println(map.get(1));
        System.out.println(map.get(11));

        map.remove(1);
        System.out.println(map.get(1));
    }
}
