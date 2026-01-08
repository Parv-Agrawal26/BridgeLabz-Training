public class UndoRedoTextEditorUsingDoubly {
    public static void main(String[] args) {
        TextHistory history = new TextHistory(10);

        history.addState("Hello");
        history.addState("Hello World");
        history.addState("Hello World!\nThis is a text editor.");

        System.out.println("Current state:");
        System.out.println(history.getCurrent());

        System.out.println("\nUndo:");
        history.undo();
        System.out.println(history.getCurrent());

        System.out.println("\nUndo:");
        history.undo();
        System.out.println(history.getCurrent());

        System.out.println("\nRedo:");
        history.redo();
        System.out.println(history.getCurrent());

        System.out.println("\nAdd new state after undo (clears redo history):");
        history.addState("Hello Universe");
        System.out.println(history.getCurrent());

        System.out.println("\nRedo (should not be possible):");
        history.redo();
        System.out.println(history.getCurrent());

        System.out.println("\nAdding many states to show history limit (10):");
        for (int i = 1; i <= 12; i++) {
            history.addState("State " + i);
        }
        System.out.println("Current state:");
        System.out.println(history.getCurrent());
    }

    static final class TextHistory {
        private static final class Node {
            String text;
            Node prev;
            Node next;

            Node(String text) {
                this.text = text;
            }
        }

        private final int maxSize;
        private int size;
        private Node head;
        private Node tail;
        private Node current;

        TextHistory(int maxSize) {
            if (maxSize <= 0) {
                throw new IllegalArgumentException("maxSize must be positive");
            }
            this.maxSize = maxSize;
        }

        void addState(String text) {
            if (text == null) {
                text = "";
            }

            if (current != null && current.next != null) {
                Node toDelete = current.next;
                current.next = null;
                tail = current;

                while (toDelete != null) {
                    Node next = toDelete.next;
                    toDelete.prev = null;
                    toDelete.next = null;
                    toDelete = next;
                    size--;
                }
            }

            Node newNode = new Node(text);
            if (head == null) {
                head = newNode;
                tail = newNode;
                current = newNode;
                size = 1;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                current = newNode;
                size++;
            }

            trimToMax();
            System.out.println("New state added");
        }

        boolean undo() {
            if (current == null) {
                System.out.println("No states.");
                return false;
            }
            if (current.prev == null) {
                System.out.println("Cannot undo.");
                return false;
            }
            current = current.prev;
            System.out.println("Undo successful");
            return true;
        }

        boolean redo() {
            if (current == null) {
                System.out.println("No states.");
                return false;
            }
            if (current.next == null) {
                System.out.println("Cannot redo.");
                return false;
            }
            current = current.next;
            System.out.println("Redo successful");
            return true;
        }

        String getCurrent() {
            if (current == null) {
                return "";
            }
            return current.text;
        }

        private void trimToMax() {
            while (size > maxSize) {
                if (head == null) {
                    break;
                }
                Node oldHead = head;
                head = head.next;
                if (head != null) {
                    head.prev = null;
                } else {
                    tail = null;
                }
                if (current == oldHead) {
                    current = head;
                }
                oldHead.next = null;
                oldHead.prev = null;
                size--;
            }
        }
    }
}
