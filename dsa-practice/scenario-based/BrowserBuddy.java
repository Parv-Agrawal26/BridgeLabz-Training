
import java.util.Stack;

class BrowserBuddy {

    static class Page {
        String url;
        Page prev;
        Page next;

        Page(String url) {
            this.url = url;
        }
    }

    private Page current;
    private Stack<Page> closedTabs = new Stack<>();

    void visit(String url) {

        Page page = new Page(url);
        if (current != null) {
            current.next = page;
            page.prev = current;
        }
        current = page;
    }

    void back() {

        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    void forward() {

        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    void closeTab() {

        if (current != null) {
            closedTabs.push(current);
            current = current.prev;
        }
    }

    void restoreTab() {

        if (!closedTabs.isEmpty()) {
            current = closedTabs.pop();
        }
    }

    void showCurrent() {

        if (current != null)
            System.out.println("Current page: " + current.url);
    }

    public static void main(String[] args) {

        BrowserBuddy browser = new BrowserBuddy();
        browser.visit("google.com");
        browser.visit("github.com");
        browser.back();
        browser.showCurrent();
    }
}
