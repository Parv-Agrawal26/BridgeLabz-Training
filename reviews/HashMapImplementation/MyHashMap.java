public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }

    Node[] bucketArray = new Node[10];

    void put(int key, int value){
        int index = key % bucketArray.length;

        if(bucketArray[index]==null){
            bucketArray[index]= new Node(key, value);
            System.out.println("Inserted key: "+key+" with value: "+value);
            return;
        }

        Node temp = bucketArray[index];
        while(temp.next!=null && temp.key!=key){
            temp=temp.next;
        }
        if(temp.key==key) temp.value=value;
        else temp.next=new Node(key, value);
        System.out.println("Inserted key: " + key + " with value: " + value);
    }

    int get(int key){
        int index = key%bucketArray.length;
        Node temp = bucketArray[index];
        while(temp.key!=key){
            temp=temp.next;
        }
        return temp.value;
    }

    void remove(int key){
        int index = key % bucketArray.length;
        Node temp = bucketArray[index];
        Node prev = null;

        while (temp != null && temp.key!=key) {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Key is not available");
            return;
        }
        if(prev==null){
            bucketArray[index]=temp.next;
        }else{
            prev.next=temp.next;
        }
        System.out.println("Key "+key+" removed successfully");
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 10);
        myHashMap.put(2, 20);
        myHashMap.put(2,22);
        System.out.println("Value for key 1: " + myHashMap.get(1));
        System.out.println("Value for key 2: " + myHashMap.get(2));
        myHashMap.remove(2);
    }

}
