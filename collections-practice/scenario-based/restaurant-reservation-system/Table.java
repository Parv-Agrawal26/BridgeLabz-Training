public class Table {

    private int tableNumber;
    private int capacity;
    private boolean reserved;

    public Table(int tableNumber,int capacity){
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.reserved = false;
    }

    public int getTableNumber(){
        return tableNumber;
    }

    public boolean isReserved(){
        return reserved;
    }

    public void setReserved(boolean reserved){
        this.reserved = reserved;
    }

    public int getCapacity(){
        return capacity;
    }
}
