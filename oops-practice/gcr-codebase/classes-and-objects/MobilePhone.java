public class MobilePhone {
    String brand;
    String model;
    double price;

    public void setDetails(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public void printDetails() {
        System.out.println("Brand of mobile : " + brand);
        System.out.println("Modelof mobile : " + model);
        System.out.println("Price of mobile : " + price);
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone();
        phone1.setDetails("Apple", "iPhone 13", 90000);
        MobilePhone phone2 = new MobilePhone();
        phone2.setDetails("Samsung", "Galaxy S21", 70000);
        phone1.printDetails();
        System.out.println();
        phone2.printDetails();
    }
}
