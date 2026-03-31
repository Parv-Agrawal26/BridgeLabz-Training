public class UndoRedoTextEditorUsingDoubly{
    TextState head;
    TextState tail;
    TextState current;
    int size;
    final int max=10;
    
    void addState(String newText) {

        if (current != null && current != tail) {
            TextState temp = current.next;
            current.next = null;
            tail = current;
            while (temp != null) {
                size--;
                temp = temp.next;
            }
        }
        TextState newState = new TextState(newText);

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = current = newState;
        size++;

        if (size > max) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.text);
        } else {
            System.out.println("No more undos available.");
        }
    }

    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.text);
        } else {
            System.out.println("No more redos available.");
        }
    }

    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {
        UndoRedoTextEditorUsingDoubly editor = new UndoRedoTextEditorUsingDoubly();
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello, Universe!");
        editor.displayCurrentState();

        editor.redo();
    }
}

class TextState{
    String text;
    TextState prev;
    TextState next;

    public TextState(String text){
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}