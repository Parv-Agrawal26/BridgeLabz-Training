
class ParcelTracker {

    static class Stage {
        String name;
        Stage next;

        Stage(String name) {
            this.name = name;
        }
    }

    Stage head;

    void addStage(String stageName) {

        if (head == null) {
            head = new Stage(stageName);
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Stage(stageName);
    }

    void trackParcel() {

        Stage temp = head;
        while (temp != null) {
            System.out.println(temp.name);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        ParcelTracker tracker = new ParcelTracker();
        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("Delivered");
        tracker.trackParcel();
    }
}
