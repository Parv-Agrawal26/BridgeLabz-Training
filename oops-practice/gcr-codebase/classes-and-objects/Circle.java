public class Circle {
    private double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    private double calculateArea() {
        return Math.PI * radius * radius;
    }
    private double circumference() {
        return 2 * Math.PI * radius;
    }
    public void printDetails(){
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + circumference());
    }
    public static void main(String[] args) {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(10.0);
        circle1.printDetails();
        System.out.println();
        circle2.printDetails();
    }
}
