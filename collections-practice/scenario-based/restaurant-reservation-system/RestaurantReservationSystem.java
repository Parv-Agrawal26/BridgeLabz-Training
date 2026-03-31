import java.util.*;

public class RestaurantReservationSystem {

    private Map<Integer,Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public RestaurantReservationSystem(){
        tables.put(1,new Table(1,4));
        tables.put(2,new Table(2,2));
        tables.put(3,new Table(3,6));
    }

    public void reserveTable(String name,int tableNumber,String timeSlot)
            throws TableAlreadyReservedException {

        Table table = tables.get(tableNumber);

        if(table == null){
            System.out.println("Table not found");
            return;
        }

        if(table.isReserved()){
            throw new TableAlreadyReservedException(
                "Table "+tableNumber+" already reserved"
            );
        }

        table.setReserved(true);
        reservations.add(new Reservation(name,tableNumber,timeSlot));
        System.out.println("Table "+tableNumber+" reserved for "+name);
    }

    public void cancelReservation(int tableNumber){
        Table table = tables.get(tableNumber);

        if(table != null){
            table.setReserved(false);
            reservations.removeIf(r -> r.getTableNumber() == tableNumber);
            System.out.println("Reservation cancelled for table "+tableNumber);
        }
    }

    public void showAvailableTables(){
        System.out.println("Available Tables:");
        for(Table table : tables.values()){
            if(!table.isReserved()){
                System.out.println("Table "+table.getTableNumber()
                    +" Capacity "+table.getCapacity());
            }
        }
    }

    public static void main(String[] args){

        RestaurantReservationSystem system =
            new RestaurantReservationSystem();

        try{
            system.reserveTable("Rohit",1,"7PM-8PM");
            system.reserveTable("Aman",1,"8PM-9PM");
        }
        catch(TableAlreadyReservedException e){
            System.out.println(e.getMessage());
        }

        system.showAvailableTables();
        system.cancelReservation(1);
        system.showAvailableTables();
    }
}
