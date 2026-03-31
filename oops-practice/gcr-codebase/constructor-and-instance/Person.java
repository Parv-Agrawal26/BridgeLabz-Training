public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void show() {
        System.out.println(name + " " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Amit", 22);
        Person p2 = new Person(p1);
        p2.show();
    }
}
